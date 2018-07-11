package exampro.controller;

import exampro.entity.UserEntity;
import exampro.entity.enums.UserRole;
import exampro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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
        userEntity.setRoles(Collections.singleton(UserRole.Student));
        userService.save(userEntity);

        return "redirect:/secure/login";
    }

    @GetMapping("users")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping("saveUser/{id}")
    public String editUser(@PathVariable("id") int id,
                           @RequestParam Map<String, String> formMap,
                           @RequestParam("login") String login) {

        UserEntity userEntity = userService.getById(id);

        userEntity.setLogin(login);
        Set<String> roles = Arrays.stream(UserRole.values())
                .map(UserRole::name)
                .collect(Collectors.toSet());

        userEntity.getRoles().clear();

        for (String key : formMap.keySet()) {
            if (roles.contains(key)) {
                userEntity.getRoles().add(UserRole.valueOf(key));
            }
        }
        userService.save(userEntity);

        return "redirect:/secure/users";
    }
}
