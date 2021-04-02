package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.dao.NewUserRepository;
import com.example.CarParkManagementSystem.model.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Document(collection = "user_table")
public class SignUpController {
    public NewUser newUser = new NewUser();

    @Autowired
    NewUserRepository newUserRepository;

    @Autowired
    public void setNewUserRepository(NewUserRepository newUserRepository){
        this.newUserRepository=newUserRepository;
    }

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        model.addAttribute("signUpTag", newUser);
        return "signUp";
    }

//    @PostMapping("/signUpTag")
//    public String signUpSubmit(@ModelAttribute NewUser newUser, Model model) {
//        model.addAttribute("signUpTag", newUser);
//        return "signUpResult";
//    }

    @PostMapping("/signUpTag")
    public String signUpSubmit(@ModelAttribute NewUser newUser,Model model) {
        model.addAttribute("user_table",newUser );
        newUserRepository.save(newUser);
        return "signUpResult";
    }

}
