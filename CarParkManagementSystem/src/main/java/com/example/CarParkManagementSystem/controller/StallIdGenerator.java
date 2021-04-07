package com.example.CarParkManagementSystem.controller;

public class StallIdGenerator {

    private int nextId;

    public StallIdGenerator (){
        //Get current Stalls from db or args
        //Get Last ID from list of stalls


        nextId = 0;
    }

    public int getNextId()
    {
        return ++nextId;
    }
}
