package exampro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure")
public class Secure {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("registration")
    public String registerNewUser() {
        return "register";
    }
}