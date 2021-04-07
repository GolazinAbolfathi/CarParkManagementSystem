package com.example.CarParkManagementSystem.dao;


import com.example.CarParkManagementSystem.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersDatabase extends MongoRepository<User, String> {
    // Basic methods are pre-defined in MongoRepository
    // Extras can be added here
    User getUserByUsernameAndPassword(String username, String password);
}
