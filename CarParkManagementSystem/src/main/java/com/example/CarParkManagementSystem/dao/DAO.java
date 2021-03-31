package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DAO {
    @Autowired
    private Repository repository;

    public Collection<User> getUser(){
        return  repository.findAll();
    }
    public User createUser(User user){
        return repository.insert(user);
    }
}
