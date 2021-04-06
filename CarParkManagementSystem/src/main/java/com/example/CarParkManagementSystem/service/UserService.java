package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //Insert
    User createNewUser(User user);

    //Update
    User updateUser(User user);

    //Delete
    void deleteUser(int newUserId);

    //Select
    List<User> readUser();

    List <User> getAllUsers();

    List < String > getAllEmails();

    User getUserById(int newUserId);

//    User getUserByUserName(String user_name);

    }