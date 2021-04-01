package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.entity.*;

public interface IParkingController {

    public void parkCar (int stallNum, int plannedExitTime, String plateNum);

    public void createLot();

    public void createStall (int lotNum);

    public void pay(int passNum, PaymentMethod paymentMethod);

    public void addUser(String firstName, String lastName, String email, String address, int phoneNum, String password, boolean userType);
}
