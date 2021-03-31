package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {

    @RequestMapping("/signIn")
    public  String getHomePage(@ModelAttribute("user") Model model){
        return "signIn";
    }
}
