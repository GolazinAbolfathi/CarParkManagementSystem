package com.example.CarParkManagementSystem.controller;
import com.example.CarParkManagementSystem.model.User;

import java.util.Random;

public class AutoIdGenerator {

//    public int generateUserId() {
//        // Random Number Generator
//        Random rand = new Random();
//        int newUserId = 1000 + rand.nextInt(100);
//        return newUserId;
//    }

    public static int generateUserId(User user) {

        int user_id = 0;
        if (user.getUser_type() == 1) {
            user_id = 100000000 + getGenerateUserId();

        } else if (user.getUser_type() == 2) {
            user_id = 200000000 + getGenerateUserId();

        }
        return user_id;

    }

    // Random Number Generator
    public static int getGenerateUserId() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rand = new Random();
        int result= rand.nextInt(1000000);
        return result;


    }
}
