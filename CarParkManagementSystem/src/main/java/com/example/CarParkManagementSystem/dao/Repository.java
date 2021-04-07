package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.model.NewUser;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<NewUser, Long> {

    @Override
    public void delete(NewUser user);
}
