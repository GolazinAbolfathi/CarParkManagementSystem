package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.dao.NewUserRepository;
import com.example.CarParkManagementSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NewUserServiceImp implements NewUserService {

    @Autowired
    private NewUserRepository newUserRepository;

    @Override
    public User createNewUser(User user) {

        return newUserRepository.save(user);
    }

    @Override
    public List<User> readUser() {
//        return newUserRepository.findAll();
        return null;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> newUserDb = this.newUserRepository.findById(user.getUserId());

//        if (newUserDb.isPresent()) {
            User userUpdate = newUserDb.get();
            userUpdate.setUserId(user.getUserId());
            userUpdate.setUser_name(user.getUser_name());
            userUpdate.setLast_name(user.getLast_name());
            userUpdate.setAddress(user.getAddress());
            userUpdate.setContact_number(user.getContact_number());
            newUserRepository.save(userUpdate);
            return userUpdate;
//        }
//        else {
//            throw new ResourceNotFoundException("Record not found with id : " + newUser.getUser_id());
//        }
    }

    @Override
    public List <User> getAllUsers() {
        return (List<User>) this.newUserRepository.findAll();
    }

    @Override
    public  List<String > getAllEmails() {
        List <String> emailList = new ArrayList<String>();
        List <User> users=this.getAllUsers();
        for(User user : users){
            emailList.add(user.getEmail());
        }
        return emailList;
    }

    @Override
    public User getUserById(int newUserId) {

        Optional <User> newUserDb = this.newUserRepository.findById(newUserId);

//        if (newUserDb.isPresent()) {
            return newUserDb.get();
//        } else {
//            throw new ResourceNotFoundException("Record not found with id : " + newUserId);
//        }
    }
    @Override
    public void deleteUser(int newUserId) {
        Optional <User> newUserDb = this.newUserRepository.findById(newUserId);

//        if (productDb.isPresent()) {
            this.newUserRepository.delete(newUserDb.get());
//        } else {
//            throw new ResourceNotFoundException("Record not found with id : " + newUserId);
//        }
    }

//    @Override
//    public NewUser getUserByUserName(String user_name){
//        Optional < NewUser > newUserDb = this.newUserRepository.(newUserId);
//
////        if (newUserDb.isPresent()) {
//        return newUserDb.get();
////        } else {
////            throw new ResourceNotFoundException("Record not found with id : " + newUserId);
////        }
//    }

}
