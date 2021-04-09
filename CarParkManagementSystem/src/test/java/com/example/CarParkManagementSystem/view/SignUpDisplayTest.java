package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.controller.ParkingSystemController;
import com.example.CarParkManagementSystem.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SignUpDisplayTest {

    @Autowired
    private IParkingController iParkingController;

    @Test
    void signUpForm() {
    }

    @Test
    void createNewUser() {

        // Arrange
        User user;
        iParkingController=new ParkingSystemController();
        user=iParkingController.addUser(
                "Smatt",
                "Mithieson",
                "", "",
                "",
                "","",
                0
        );

        // Assert
        assertNotNull(user);

        // Act
//        model.addAttribute("user", user);
        System.out.println("test works");
    }
}