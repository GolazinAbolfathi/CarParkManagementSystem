package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.controller.ParkingSystemController;
import com.example.CarParkManagementSystem.entity.User;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import static org.junit.jupiter.api.Assertions.*;

public class SignUpDisplayTest {
//    private MockMvc mockMvc;

    public SignUpDisplayTest(){

    }
    @Autowired
    private IParkingController iParkingController;

    Model model;

//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
//    @Test
//    void signUpForm() throws Exception {
//        this.mockMvc.perform(get("/signUpTag"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("signUpResult"));
//    }

    @Test
    public void createNewUser() {
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
        model.addAttribute("user", user);
    }
}