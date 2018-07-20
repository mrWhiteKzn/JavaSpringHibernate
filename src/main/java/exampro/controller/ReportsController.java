package exampro.controller;

import exampro.entity.UserEntity;
import exampro.entity.enums.UserRole;
import exampro.reports.ExamResultOfUser;
import exampro.service.QuestionService;
import exampro.service.ResultService;
import exampro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    private ResultService resultService;
    private UserService userService;
    private QuestionService questionService;

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("recently")
    public String showRecently(Model model){
        model.addAttribute("examResultList",resultService.getRecentlyResults());
        return "recently";
    }

    @GetMapping("byUser/{id}")
    public String byUser(@PathVariable("id") int id, Model model) {
        UserEntity userEntity = userService.getById(id);

        List<ExamResultOfUser> examResultOfUserList = resultService.getResultListByUser(userEntity);

        model.addAttribute("examResultOfUserList", examResultOfUserList);
        model.addAttribute("user", userEntity);
        model.addAttribute("roles", UserRole.values());
        return "reportsOfUser";
    }

    @GetMapping("byExam/{id}")
    public String byExam(@PathVariable("id") int resultId, Model model) {
        model.addAttribute("questionResultDetailList", resultService.getQuestionResults(resultId));
        model.addAttribute("resultId", resultId);
        return "examResultDetail";
    }

    @PostMapping("explanation/{id}")
    public String getRightAnswers(@PathVariable("id") int questionId,
                                  @RequestParam("resultId") int resultId,
                                  Model model) {
        model.addAttribute("question", questionService.getQuestion(questionId));
        model.addAttribute("choosenAnswersIdList", resultService.getChoosenAnswersIdList(resultId));
        return "showQuestion";
    }
}
