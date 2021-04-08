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
    //https://www.djamware.com/post/59b606e280aca768e4d2b13b/spring-boot-mvc-data-and-mongodb-crud-java-web-application

}
