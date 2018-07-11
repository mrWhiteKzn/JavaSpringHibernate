package exampro.controller;

import exampro.entity.UserEntity;
import exampro.entity.enums.UserRole;
import exampro.reports.ExamResultOfUser;
import exampro.service.ResultService;
import exampro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    private ResultService resultService;
    private UserService userService;

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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
    public String byExam(@PathVariable("id") int id, Model model) {
        model.addAttribute("examResultDetailList", resultService.getResultsByExam(id));
        return "examResultDetail";
    }
}
