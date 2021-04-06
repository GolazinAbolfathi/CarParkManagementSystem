package com.example.CarParkManagementSystem.entity;


import com.example.CarParkManagementSystem.controller.AutoIdGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Random;

/**
 * @author Soheila Hoseini - 300311938
 * This is the user model
 */
//!!!!!!!!!!!!!  add username field
@Document(collection = "user_table")
public class User {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="LICENSE_SEQ")
    private int user_id;
    public String first_name;
    private String last_name;
    private String email;
    private String address;
    private String contact_number;
    private String password;
    //    @Field()
    private String user_name;
    private int user_type;

//    public NewUser(String first_name, String last_name, String email, String address, String contact_number, String password, String user_name) {
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
//        this.address = address;
//        this.contact_number = contact_number;
//        this.password = password;
//        this.user_name = user_name;
//    }

    public User() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }
}
