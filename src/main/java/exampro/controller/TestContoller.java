package exampro.controller;

import exampro.service.QuestionService;
import exampro.service.TestService;
import exampro.containerClasses.TestContainer;
import exampro.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exam")
public class TestContoller {

    TestService testService;
    QuestionService questionService;

    @Autowired
    public void setTestService(TestService testService){
        this.testService=testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) { this.questionService = questionService; }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getall")
    public String  getAll(Model model){
        model.addAttribute("tests", testService.findAll());
        return "getAll";
    }

    //Return page with containter TestContainer
    @GetMapping("/gettest/{id}")
    public String getTest(@PathVariable("id") int id, Model model){
        model.addAttribute("testContainer", testService.getTestContainer(id));
        return "test";
    }

    @GetMapping("/edit/{id}")
    public String editTest(@PathVariable("id") int id, Model model){
        model.addAttribute("testContainer", testService.getTestContainer(id));
        return "editTest";
    }

    @PostMapping("/updateTest")
    public String updateTest(@ModelAttribute("editedTestContainer") TestContainer testContainer){
        //testService.saveOrUpdate(testContainer);
        System.out.println(testContainer.toString());
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
    public String addQuestion(@ModelAttribute ("question") QuestionEntity questionEntity, @PathVariable("id") int id){
        testService.saveOrUpdate(questionEntity, id);
        return "redirect:/exam/getall";
    }
}
