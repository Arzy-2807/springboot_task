package com.peaksoft.controller;

import com.peaksoft.model.User;
import com.peaksoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsers( Model model) {
        model.addAttribute("listUsers",userService.findAll() );
        return "main-page";
    }



    @GetMapping("/add-user")
    public String addUser(Model model ) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping("/save-user")
    private String save(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/update-user/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/delete-user/{id}")
    public String delete(@PathVariable(value = "id") Integer id){
       this.userService.deleteById(id);
       return "redirect:/";
    }

}
