package com.example.CarParkManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controller_Class {

    @RequestMapping("/")
    public String homePage(Model model) {
        return "home";
    }

    //https://spring.io/guides/gs/handling-form-submission/

}
