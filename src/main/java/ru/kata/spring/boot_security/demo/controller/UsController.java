package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/user")
public class UsController {
    @Autowired
    private  UserService userService;
@GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model){
    SecurityContext securityContext = SecurityContextHolder.getContext();
    var w=userService.findAll()
            .stream().filter(user1->user1.getUsername().equals(securityContext.getAuthentication().getName()))
            .collect(Collectors.toList()).stream().findFirst().orElse(null);
    User users = userService.findById(id);
    model.addAttribute("users", users);  //передать в юз html юз
    model.addAttribute("user", w);
    return "user";     // путь к html файлу(название html)
    }

}
