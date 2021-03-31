package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.dao.DAO;
import com.example.CarParkManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class UserService {
    @Autowired
    private DAO dao; // obj of the class BookDAO

    public Collection<User> getUser()
    {
        return dao.getUser();
    }
    public User createUser(User user) {
        return dao.createUser(user);
    }
}
