package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.model.NewUser;
import com.example.CarParkManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface NewUserRepository extends CrudRepository<NewUser, Integer> {

//    @Override
//    public void delete(NewUser newUser);

}
