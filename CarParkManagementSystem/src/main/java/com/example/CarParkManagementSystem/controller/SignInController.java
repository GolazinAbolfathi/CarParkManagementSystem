package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.model.signInUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {

    signInUser signInUser = new signInUser();

    @GetMapping("/signIn")
    public String greetingForm(Model model) {
        model.addAttribute("signInTag", signInUser);
        return "signIn";
    }

    @PostMapping("/signInTag")
    public String greetingSubmit(@ModelAttribute signInUser signInUser, Model model) {
        model.addAttribute("signInTag", signInUser);
        return "result";
    }


//    @Autowired
//    private UserService userService;

    //    @GetMapping
//    public Collection<signInUser> getUser()
//    {
//        return userService.getUser();
//    }



//    @PostMapping()
//    public signInUser postUser(@RequestBody signInUser temp)
//    {
//        temp=signInUser;
//        return userService.createUser(temp);
//    }

}
