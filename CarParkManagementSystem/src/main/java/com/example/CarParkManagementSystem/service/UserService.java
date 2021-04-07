package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class UserService {

    public Collection<User> getUser()
    {
        return dao.getUser();
    }

}
