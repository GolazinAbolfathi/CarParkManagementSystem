package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.dao.*;
import com.example.CarParkManagementSystem.entity.*;

import java.util.Date;

public class ParkingSystemController implements IParkingController {
    private final Configuration config;
    IDatabaseManager iDB;
    Calculator calc;

    public ParkingSystemController(Configuration config) {
        iDB = new DatabaseManager();
        this.config = config;
        calc = new Calculator(
            Double.parseDouble(config.get("price")),
            Double.parseDouble(config.get("overtime"))
        );
    }

    @Override
    public void parkCar(int stallNum, int durationOfStay, String plateNum) {

        Date startTime = calc.getCurrentTime();
        Date exitTime = Date.from(
            startTime.toInstant().plusSeconds(durationOfStay * 60L * 60)
        );
        ParkingPass pass = new ParkingPass(
            plateNum,
            iDB.getParkingStall(stallNum),
            startTime,
            exitTime
        );
        iDB.addParkingPass(pass);
    }

    @Override
    public void createLot() {

    }

    @Override
    public void createStall(int lotNum) {

    }

    @Override
    public void pay(int passNum, PaymentMethod paymentMethod) {

    }

    @Override
    public void addUser(String firstName, String lastName, String email, String address, int phoneNum, String password, boolean userType) {

    }
}
