package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.dao.NewUserRepository;
import com.example.CarParkManagementSystem.model.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NewUserServiceImp implements NewUserService {

    @Autowired
    private NewUserRepository newUserRepository;

    @Override
    public NewUser createNewUser(NewUser newUser) {
        return newUserRepository.save(newUser);
    }

    @Override
    public List<NewUser> readUser() {
//        return newUserRepository.findAll();
        return null;
    }

    @Override
    public NewUser updateUser(NewUser newUser) {
        Optional<NewUser> newUserDb = this.newUserRepository.findById(newUser.getUser_id());

//        if (newUserDb.isPresent()) {
            NewUser newUserUpdate = newUserDb.get();
            newUserUpdate.setUser_id(newUser.getUser_id());
            newUserUpdate.setUser_name(newUser.getUser_name());
            newUserUpdate.setLast_name(newUser.getLast_name());
            newUserUpdate.setAddress(newUser.getAddress());
            newUserUpdate.setContact_number(newUser.getContact_number());
            newUserRepository.save(newUserUpdate);
            return newUserUpdate;
//        }
//        else {
//            throw new ResourceNotFoundException("Record not found with id : " + newUser.getUser_id());
//        }
    }

    @Override
    public List < NewUser > getAllUsers() {
        return (List<NewUser>) this.newUserRepository.findAll();
    }

    @Override
    public NewUser getUserById(int newUserId) {

        Optional < NewUser > newUserDb = this.newUserRepository.findById(newUserId);

//        if (newUserDb.isPresent()) {
            return newUserDb.get();
//        } else {
//            throw new ResourceNotFoundException("Record not found with id : " + newUserId);
//        }
    }
    @Override
    public void deleteUser(int newUserId) {
        Optional < NewUser > newUserDb = this.newUserRepository.findById(newUserId);

//        if (productDb.isPresent()) {
            this.newUserRepository.delete(newUserDb.get());
//        } else {
//            throw new ResourceNotFoundException("Record not found with id : " + newUserId);
//        }
    }
}
