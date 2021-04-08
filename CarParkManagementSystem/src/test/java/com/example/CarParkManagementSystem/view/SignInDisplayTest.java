package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.entity.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class SignInDisplayTest {

//    @RunWith(SpringJUnit4ClassRunner.class)
//    @WebAppConfiguration
//    @ContextConfiguration(classes = SampleWebApplication.class)

        @Autowired
        private WebApplicationContext wac;

        private MockMvc mockMvc;

    @Autowired
    IParkingController controller;

//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }

    @Test
    void signInSubmit(@ModelAttribute User user, Model model) {

//        this.mockMvc.perform(get("/signIn/signInTag"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("logInHome"));


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