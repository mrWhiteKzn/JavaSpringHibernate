package exampro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure")
public class SecureController {

    @GetMapping("login")
    public String login() {
        System.out.println("##########################LOGIN EXECUTION!!");
        return "login";
    }

    @GetMapping("registration")
    public String registerNewUser() {
        return "registration";
    }

//    @PostMapping("logout")
//    public String logout(){
//
//    }
}
