package exampro.controller;

import exampro.containerClasses.QuestionContainer;
import exampro.entity.TestEntity;
import exampro.entity.UserEntity;
import exampro.service.AnswerService;
import exampro.service.QuestionService;
import exampro.service.ResultService;
import exampro.service.TestService;
import exampro.containerClasses.TestContainer;
import exampro.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getall")
    public String  getAll(Model model){
        model.addAttribute("tests", testService.findAll());
        return "getAll";
    }

    @GetMapping("/addnew")
    @PreAuthorize("hasAuthority('Admin')")
    public String addNew(Model model) {
        TestContainer testContainer = new TestContainer();
        model.addAttribute(testContainer);
        return "addNew";
    }

    @PostMapping("/addNew")
    @PreAuthorize("hasAuthority('Admin')")
    public String addNew(@ModelAttribute TestEntity testEntity) {
        TestContainer testContainer = new TestContainer();
        testContainer.setTestEntity(testEntity);
        testService.saveOrUpdate(testContainer);
        return "redirect:/exam/edit/" + testContainer.getTestEntity().getId();
    }

    @GetMapping("/gettest/{id}")
    public String getTest2(@PathVariable("id") int id, Model model){
        model.addAttribute("test", testService.getTestEntity(id));
        model.addAttribute("questionList", questionService.getQuestionsList(testService.getTestEntity(id)));
        return "test";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public String editTest(@PathVariable("id") int id, Model model){
        model.addAttribute("testContainer", testService.getTestContainer(id));
        return "editTest";
    }

    @PostMapping("/updateTest")
    @PreAuthorize("hasAuthority('Admin')")
    public String updateTest(@ModelAttribute("testContainer") TestContainer testContainer) {
        testService.saveOrUpdate(testContainer);
        return "redirect:/exam/getall";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public String delete(@PathVariable("id") int id, @AuthenticationPrincipal UserEntity userEntity) {
        testService.delete(id);
        return "redirect:/exam/getall";
    }

    @GetMapping("/deleteQuestion/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public String deleteQuestion(@PathVariable("id") int id) {
        int testId = questionService.getQuestion(id).getTestEntity().getId();
        questionService.delete(id);
        return "redirect:/exam/edit/" + testId;
    }

    @PostMapping("updateQuestion/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public String editQuestion(@ModelAttribute("container") QuestionContainer questionContainer,
                               @PathVariable("id") int id,
                               Model model) {
        questionService.saveOrUpdate(questionContainer.getQuestionEntity());
        model.addAttribute("question", questionContainer.getQuestionEntity());
        return "redirect:/exam/editQuestion/" + id;
    }

    @GetMapping("addQuestion/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public String addQuestion(@PathVariable("id") int id, Model model){
        QuestionEntity questionEntity = new QuestionEntity();

        model.addAttribute("testEntity",testService.getTestContainer(id).getTestEntity());
        model.addAttribute("question", questionEntity);
        return "addQuestion";
    }

    @PostMapping("addQuestion/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public String addQuestion(@ModelAttribute("question") QuestionEntity questionEntity,
                              @PathVariable("id") int testId) {
        testService.saveOrUpdate(questionEntity, testId);

        return "redirect:/exam/edit/" + testId;
    }

    @GetMapping("editQuestion/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public String editQuestion(@PathVariable("id") int id, Model model) {
        QuestionEntity questionEntity = questionService.getQuestion(id);

        QuestionContainer questionContainer = new QuestionContainer();
        questionContainer.setQuestionEntity(questionEntity);
        questionContainer.setAnswerEntityList(questionEntity.getAnswerEntityList());

        model.addAttribute(questionContainer);
        return "editQuestion";
    }

    @PostMapping("updateAnswers/")
    @PreAuthorize("hasAuthority('Admin')")
    public String updateAnswers(@ModelAttribute("questionContainer") QuestionContainer questionContainer, Model model) {
        answerService.updateAnswers(questionContainer);
        model.addAttribute("successSave", "Успешно сохранено!");
        return "redirect:/exam/editQuestion/" + questionContainer.getQuestionEntity().getId();
    }

    @PostMapping("saveResult/{id}")
    public String saveResult(@RequestParam MultiValueMap<String, String> selectedAnswers,
                             @PathVariable("id") int testId,
                             @AuthenticationPrincipal UserEntity userEntity,
                             Model model) {
        resultService.saveTestResult(selectedAnswers, testId, userEntity);

        model.addAttribute("lastExamination", resultService.getLastExamination(userEntity));
        return "examFinished";
    }

}
