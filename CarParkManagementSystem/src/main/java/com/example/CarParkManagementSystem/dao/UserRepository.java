package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

//    @Override
//    public void delete(User user);

}
