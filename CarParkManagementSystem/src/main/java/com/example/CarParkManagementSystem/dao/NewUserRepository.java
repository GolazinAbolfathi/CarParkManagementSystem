package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.model.NewUser;
import com.example.CarParkManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewUserRepository extends CrudRepository<NewUser, Long> {

    @Override
    public void delete(NewUser newUser);

}
