package com.example.CarParkManagementSystem.controller;
import java.util.Random;

public class AutoIdGenerator {

    public int generateUserId() {
        // Random Number Generator
        Random rand = new Random();
        int newUserId = 1000 + rand.nextInt(100);
        return newUserId;
    }
}
