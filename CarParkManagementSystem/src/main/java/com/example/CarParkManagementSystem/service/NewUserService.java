package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.model.NewUser;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

@Service
public interface NewUserService {

    NewUser createNewUser(NewUser newUser);

    List<NewUser> readUser();

    NewUser updateUser(NewUser newUser);

    void deleteUser(int newUserId);

    List < NewUser > getAllUsers();

    NewUser getUserById(int newUserId);

    }