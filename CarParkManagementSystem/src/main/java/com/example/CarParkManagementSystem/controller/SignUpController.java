package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.model.NewUser;
import com.example.CarParkManagementSystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    NewUser newUser = new NewUser();

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        model.addAttribute("signUpTag", newUser);
        return "signUp";
    }

    @PostMapping("/signUpTag")
    public String signUpSubmit(@ModelAttribute NewUser newUser, Model model) {
        model.addAttribute("signUpTag", newUser);
        return "signUpResult";
    }
}
