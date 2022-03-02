package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  UserService userService;

    @GetMapping("/user")  //(ввод в браузере)
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);  //передать в юз html юз
        return "userList";     // путь к html файлу(название html)
    }
}
