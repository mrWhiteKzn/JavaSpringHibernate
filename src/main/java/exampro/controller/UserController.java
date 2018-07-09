package exampro.controller;

import exampro.entity.UserEntity;
import exampro.entity.enums.UserRole;
import exampro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/secure")
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("registration")
    public String getRegistationView() {
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(UserEntity userEntity, Map<String, Object> model) {
        UserEntity userFromDb = userService.findByUserLogin(userEntity.getLogin());

        if (userFromDb != null) {
            model.put("message", "Такой пользователь уже существует!");
            return "registration";
        }

        userEntity.setActive(true);
        userEntity.setRoles(Collections.singleton(UserRole.USER));
        userService.save(userEntity);

        return "redirect:/secure/login";
    }

    @GetMapping("users")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
}
