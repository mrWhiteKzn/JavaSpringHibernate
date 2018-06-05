package exampro.controller;

import exampro.service.AnswerService;
import exampro.service.QuestionService;
import exampro.service.ResultService;
import exampro.service.TestService;
import exampro.containerClasses.TestContainer;
import exampro.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/exam")
public class TestContoller {

    TestService testService;
    QuestionService questionService;
    AnswerService answerService;
    ResultService resultService;

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
    public String updateTest(@ModelAttribute("editedTestContainer") TestContainer testContainer){
        testService.saveOrUpdate(testContainer);
        return "redirect:/exam/getall";
    }

    @GetMapping("/addnew")
    public String addNew(){
        return "addNew";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        testService.delete(id);
        return "redirect:/exam/getall";
    }

    @GetMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable("id") int id, Model model){
        questionService.delete(id);
        return "redirect:/exam/getall";
    }

    @GetMapping("editQuestion/{id}")
    public String editQuestion(@PathVariable("id") int id, Model model){
        model.addAttribute("question", questionService.getQuestion(id));
        return "editQuestion";
    }

    @PostMapping("updateQuestion/{id}")
    public String editQuestion(@ModelAttribute ("question") QuestionEntity questionEntity, Model model){
        questionService.saveOrUpdate(questionEntity);
        model.addAttribute("question", questionEntity);
        return "editQuestion";
    }

    @GetMapping("addQuestion/{id}")
    public String addQuestion(@PathVariable("id") int id, Model model){
        model.addAttribute("testEntity",testService.getTestContainer(id).getTestEntity());
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

    @PostMapping("updateAnswers/{id}")
    public String updateAnswers(@RequestParam ("answerText") String[] answerTextArray,
                                @PathVariable("id") int id,
                                Model model){
        answerService.saveorUpdateList(answerTextArray, questionService.getQuestion(id));
        return "redirect:/exam/getall";
    }

    @PostMapping("saveResult/{id}")
    public String saveResult(@RequestParam MultiValueMap<String, String> selectedAnswers,
                             @PathVariable("id") int testId){

        resultService.saveTestResult(selectedAnswers, testId);
        return "redirect:/exam/getall";
    }

}
