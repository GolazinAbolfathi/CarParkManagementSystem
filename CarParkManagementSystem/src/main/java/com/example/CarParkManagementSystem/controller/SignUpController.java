package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.dao.NewUserRepository;
import com.example.CarParkManagementSystem.entity.User;
import com.example.CarParkManagementSystem.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Document(collection = "user_table")
public class SignUpController {
    public User user;
    public AutoIdGenerator autoIdGenerator;

    @Autowired
    private NewUserRepository newUserRepository;

    @Autowired
    private NewUserService newUserService;

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        user =new User();
        model.addAttribute("signUpTag", user);
        return "signUp";
    }

    @PostMapping("/signUpTag")
//    public ResponseEntity  createNewUser(@ModelAttribute NewUser newUser,Model model) {
        public String  createNewUser(@ModelAttribute User user, Model model) {

        List<String> emailList = newUserService.getAllEmails();

        String compareEmail = user.getEmail();
        if (emailList.contains(compareEmail)) {
            String failureMessage = "Already has the email address: " + compareEmail;
            model.addAttribute("failureMessage", failureMessage);

        } else {
            String successMessage = "Successfully Sign Up";
            model.addAttribute("successMessage", successMessage);
            user.setUser_id(AutoIdGenerator.generateUserId(user));
            newUserService.createNewUser(user);
        }

        model.addAttribute("user_table", user);
//        ResponseEntity.ok().body(this.newUserService.createNewUser(newUser));
        return "signUpResult";

        //        return ResponseEntity.ok().body(this.newUserService.createNewUser(newUser));

    }

    @PutMapping("/user_table/{id}")
    public ResponseEntity <User> updateProduct(@PathVariable int id, @RequestBody User user) {
        user.setUser_id(id);
        return ResponseEntity.ok().body(this.newUserService.updateUser(user));
    }

    @DeleteMapping("/user_table/{id}")
    public HttpStatus deleteUser(@PathVariable int id) {
        this.newUserService.deleteUser(id);
        return HttpStatus.OK;
    }

    @GetMapping("/user_table")
    public ResponseEntity < List <User>> getAllUsers() {
        return ResponseEntity.ok().body(newUserService.getAllUsers());
    }

    @GetMapping("/user_table/{id}")
    public ResponseEntity <User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok().body(newUserService.getUserById(id));
    }

//    @GetMapping("/user_table/{id}")
//    public ResponseEntity < NewUser > getUserByUserName(@PathVariable String user_name) {
//        return ResponseEntity.ok().body(newUserService.getUserByUserName(user_name));
//    }
}
