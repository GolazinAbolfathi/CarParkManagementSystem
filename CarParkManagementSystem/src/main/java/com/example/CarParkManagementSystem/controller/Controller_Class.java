package com.example.CarParkManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_Class {

    @RequestMapping("/")
    public String listItem()
    {

        return "home";
    }
    //https://attacomsian.com/blog/spring-boot-thymeleaf-example
    //https://hellokoding.com/spring-security-login-logout-thymeleaf/
}
