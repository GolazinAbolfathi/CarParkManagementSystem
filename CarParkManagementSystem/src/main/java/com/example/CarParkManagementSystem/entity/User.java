package com.example.CarParkManagementSystem.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//!!!!!!!!!!!!!  add username field
@Document(collection = "user_table")
public class User {
    private static int nextId = 0;
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="LICENSE_SEQ")
    private int user_id;
    public String first_name;
    private String last_name;
    private String email;
    private String address;
    private String contact_number;
    private String username;
    private String password;
    private int userType;

    public User(
            String first_name,
            String last_name,
            String email,
            String address,
            String contact_number,
            String username,
            String password,
            int userType) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.contact_number = contact_number;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public User() {
        userType = 0;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
    public void setNextId() {
        user_id = nextId++;
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

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
