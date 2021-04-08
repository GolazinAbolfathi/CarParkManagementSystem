package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.controller.ParkingSystemController;
import com.example.CarParkManagementSystem.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInDisplay {

    @GetMapping("/signIn")
    public String signInForm(Model model) {
        model.addAttribute("signInTag", new User());
        return "signIn";
    }



    @PostMapping("/signInTag")
    public String signInSubmit(@ModelAttribute User user, Model model) {

        IParkingController iParkingController=new ParkingSystemController();
        User tempUser=iParkingController.getUser(user.getUsername(),user.getPassword());

        if (tempUser.getUsername()=="")
        {
            model.addAttribute("signUpTag", user);
            return "signUp";
        }
        else
            return "logInHome";

//        model.addAttribute("signInTag", tempUser);
//        return "signInResult";
    }



}