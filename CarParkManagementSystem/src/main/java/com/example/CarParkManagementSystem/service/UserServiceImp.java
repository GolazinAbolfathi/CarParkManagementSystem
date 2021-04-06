package com.example.CarParkManagementSystem.service;

import com.example.CarParkManagementSystem.dao.UserRepository;
import com.example.CarParkManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createNewUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> readUser() {
//        return userRepository.findAll();
        return null;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> newUserDb = this.userRepository.findById(user.getUser_id());

//        if (newUserDb.isPresent()) {
            User userUpdate = newUserDb.get();
            userUpdate.setUser_id(user.getUser_id());
            userUpdate.setUser_name(user.getUser_name());
            userUpdate.setLast_name(user.getLast_name());
            userUpdate.setAddress(user.getAddress());
            userUpdate.setContact_number(user.getContact_number());
            userRepository.save(userUpdate);
            return userUpdate;
//        }
//        else {
//            throw new ResourceNotFoundException("Record not found with id : " + user.getUser_id());
//        }
    }

    @Override
    public List <User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
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

        Optional <User> newUserDb = this.userRepository.findById(newUserId);

//        if (newUserDb.isPresent()) {
            return newUserDb.get();
//        } else {
//            throw new ResourceNotFoundException("Record not found with id : " + newUserId);
//        }
    }
    @Override
    public void deleteUser(int newUserId) {
        Optional <User> newUserDb = this.userRepository.findById(newUserId);

//        if (productDb.isPresent()) {
            this.userRepository.delete(newUserDb.get());
//        } else {
//            throw new ResourceNotFoundException("Record not found with id : " + newUserId);
//        }
    }

//    @Override
//    public User getUserByUserName(String user_name){
//        Optional < User > newUserDb = this.userRepository.(newUserId);
//
////        if (newUserDb.isPresent()) {
//        return newUserDb.get();
////        } else {
////            throw new ResourceNotFoundException("Record not found with id : " + newUserId);
////        }
//    }

}
