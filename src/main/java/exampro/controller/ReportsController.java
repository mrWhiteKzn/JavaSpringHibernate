package exampro.controller;

import exampro.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    private ResultService resultService;

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("recently")
    public String showRecently(Model model){
        model.addAttribute("examResultList",resultService.getRecentlyResults());
        return "recently";
    }
}
