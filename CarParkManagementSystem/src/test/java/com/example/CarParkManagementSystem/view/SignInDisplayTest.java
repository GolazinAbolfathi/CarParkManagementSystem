package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import static org.junit.jupiter.api.Assertions.*;

class SignInDisplayTest {

    @Autowired
    IParkingController controller;

    @Autowired
    private IParkingController iParkingController;

    @Test
    void signInForm() {
    }

    @Test
    void signInSubmit(@ModelAttribute User user, Model model) {

        //Arrange
        user.setUsername("eli");
        user.setPassword("eli");
        User actual = controller.getUser(user.getUsername(),user.getPassword());

        //Assert
        assertNotNull(actual);

        //Act
        model.addAttribute("user", actual);
    }
}