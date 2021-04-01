package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {

    User user = new User();

    @GetMapping("/signIn")
    public String greetingForm(Model model) {
        model.addAttribute("signInTag", user);
        return "signIn";
    }

    @PostMapping("/signInTag")
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("signInTag", user);
        return "result";
    }


//    @Autowired
//    private UserService userService;

    //    @GetMapping
//    public Collection<User> getUser()
//    {
//        return userService.getUser();
//    }



//    @PostMapping()
//    public User postUser(@RequestBody User temp)
//    {
//        temp=user;
//        return userService.createUser(temp);
//    }

}
