package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createNewUser(User user);

    List<User> readUser();

    User updateUser(User user);

    void deleteUser(int newUserId);

    List <User> getAllUsers();

    List < String > getAllEmails();

    User getUserById(int newUserId);

//    User getUserByUserName(String user_name);

    }