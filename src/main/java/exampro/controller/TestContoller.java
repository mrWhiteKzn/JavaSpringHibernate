package exampro.controller;

import exampro.Service.QuestionService;
import exampro.Service.TestService;
import exampro.config.TestContainer;
import exampro.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        model.addAttribute("testContainer", testService.getTest(id));
        return "test";
    }

    @GetMapping("/edit/{id}")
    public String editTest(@PathVariable("id") int id, Model model){
        model.addAttribute("testContainer", testService.getTest(id));
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

}
