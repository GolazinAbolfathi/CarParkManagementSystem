package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.dao.NewUserRepository;
import com.example.CarParkManagementSystem.model.NewUser;
import com.example.CarParkManagementSystem.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
@Document(collection = "user_table")
public class SignUpController {
    public NewUser newUser = new NewUser();


    @Autowired
    private NewUserRepository newUserRepository;

    @Autowired
    private NewUserService newUserService;

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        model.addAttribute("signUpTag", newUser);
        return "signUp";
    }

    @PostMapping("/signUpTag")
    public ResponseEntity  createNewUser(@ModelAttribute NewUser newUser,Model model) {
        model.addAttribute("user_table",newUser );
        return ResponseEntity.ok().body(this.newUserService.createNewUser(newUser));
    }

    @PutMapping("/user_table/{id}")
    public ResponseEntity < NewUser > updateProduct(@PathVariable int id, @RequestBody NewUser newUser) {
        newUser.setUser_id(id);
        return ResponseEntity.ok().body(this.newUserService.updateUser(newUser));
    }

    @DeleteMapping("/user_table/{id}")
    public HttpStatus deleteUser(@PathVariable int id) {
        this.newUserService.deleteUser(id);
        return HttpStatus.OK;
    }

    @GetMapping("/user_table")
    public ResponseEntity < List < NewUser >> getAllUsers() {
        return ResponseEntity.ok().body(newUserService.getAllUsers());
    }

    @GetMapping("/user_table/{id}")
    public ResponseEntity < NewUser > getUserById(@PathVariable int id) {
        return ResponseEntity.ok().body(newUserService.getUserById(id));
    }
}
