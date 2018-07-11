package exampro.controller;

import exampro.containerClasses.QuestionContainer;
import exampro.entity.TestEntity;
import exampro.entity.UserEntity;
import exampro.entity.enums.UserRole;
import exampro.service.AnswerService;
import exampro.service.QuestionService;
import exampro.service.ResultService;
import exampro.service.TestService;
import exampro.containerClasses.TestContainer;
import exampro.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/exam")
public class TestContoller {

    private TestService testService;
    private QuestionService questionService;
    private AnswerService answerService;
    private ResultService resultService;

    @Autowired
    public void setTestService(TestService testService){
        this.testService=testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) { this.questionService = questionService; }

    @Autowired
    public void setAnswerService(AnswerService answerService) { this.answerService = answerService; }

    @Autowired
    public void setResultService(ResultService resultService) { this.resultService = resultService; }


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getall")
    public String  getAll(Model model){
        model.addAttribute("tests", testService.findAll());
        return "getAll";
    }

    /*
     * Comment for myself: think whether you should avoid class-wrapper here
     * */
    @PostMapping("/addNew")
    public String addNew(@ModelAttribute TestEntity testEntity) {
        TestContainer testContainer = new TestContainer();
        testContainer.setTestEntity(testEntity);
        testService.saveOrUpdate(testContainer);
        return "redirect:/exam/edit/" + testContainer.getTestEntity().getId();
    }

    @GetMapping("/addnew")
    public String addNew(Model model) {
        TestContainer testContainer = new TestContainer();
        model.addAttribute(testContainer);
        return "addNew";
    }

    @GetMapping("/gettest/{id}")
    public String getTest2(@PathVariable("id") int id, Model model){
        model.addAttribute("test", testService.getTestEntity(id));
        model.addAttribute("questionList", questionService.getQuestionsList(testService.getTestEntity(id)));
        return "test";
    }

    @GetMapping("/edit/{id}")
    public String editTest(@PathVariable("id") int id, Model model){
        model.addAttribute("testContainer", testService.getTestContainer(id));
        return "editTest";
    }

    @PostMapping("/updateTest")
    public String updateTest(@ModelAttribute("testContainer") TestContainer testContainer) {
        testService.saveOrUpdate(testContainer);
        return "redirect:/exam/getall";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,
                         @AuthenticationPrincipal UserEntity userEntity) {
        testService.delete(id);
        return "redirect:/exam/getall";
    }

    @GetMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable("id") int id, Model model){
        questionService.delete(id);
        return "redirect:/exam/getall";
    }

    @PostMapping("updateQuestion/{id}")
    public String editQuestion(@ModelAttribute("container") QuestionContainer questionContainer,
                               @PathVariable("id") int id,
                               Model model) {
        questionService.saveOrUpdate(questionContainer.getQuestionEntity());
        model.addAttribute("question", questionContainer.getQuestionEntity());
        return "redirect:/exam/editQuestion/" + id;
    }

    @GetMapping("addQuestion/{id}")
    public String addQuestion(@PathVariable("id") int id, Model model){
        QuestionEntity questionEntity = new QuestionEntity();

        model.addAttribute("testEntity",testService.getTestContainer(id).getTestEntity());
        model.addAttribute("question", questionEntity);
        return "addQuestion";
    }

    @PostMapping("addQuestion/{id}")
    public String addQuestion(@ModelAttribute("question") QuestionEntity questionEntity,
                              @PathVariable("id") int id,
                              @RequestParam("answerText") String[] answersTextArray){
        testService.saveOrUpdate(questionEntity, id);
        answerService.saveorUpdateList(answersTextArray, questionEntity);
        return "redirect:/exam/getall";
    }

    @GetMapping("editQuestion/{id}")
    public String editQuestion(@PathVariable("id") int id, Model model) {
        QuestionEntity questionEntity = questionService.getQuestion(id);

        QuestionContainer questionContainer = new QuestionContainer();
        questionContainer.setQuestionEntity(questionEntity);
        questionContainer.setAnswerEntityList(questionEntity.getAnswerEntityList());

        model.addAttribute(questionContainer);
        return "editQuestion";
    }

    @PostMapping("updateAnswers/")
    public String updateAnswers(@ModelAttribute("questionContainer") QuestionContainer questionContainer) {
        answerService.updateAnswers(questionContainer);
        return "redirect:/exam/getall";
    }

    @PostMapping("saveResult/{id}")
    public String saveResult(@RequestParam MultiValueMap<String, String> selectedAnswers,
                             @PathVariable("id") int testId,
                             @AuthenticationPrincipal UserEntity userEntity) {
        resultService.saveTestResult(selectedAnswers, testId, userEntity);
        return "redirect:/exam/getall";
    }

}
