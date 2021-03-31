package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository <User, Long> {
}
