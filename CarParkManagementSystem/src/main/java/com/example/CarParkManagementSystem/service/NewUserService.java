package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewUserService {

    User createNewUser(User user);

    List<User> readUser();

    User updateUser(User user);

    void deleteUser(Long newUserId);

    List <User> getAllUsers();

    List < String > getAllEmails();

    User getUserById(Long newUserId);

//    NewUser getUserByUserName(String user_name);

    }