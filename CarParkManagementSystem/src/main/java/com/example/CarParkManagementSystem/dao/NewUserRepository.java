package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface NewUserRepository extends CrudRepository<User, Integer> {

//    @Override
//    public void delete(NewUser newUser);

}
