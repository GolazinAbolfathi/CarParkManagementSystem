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
    public ParkingPass parkCar(int lotid, int stallNum, int plannedDuration, String plateNum) {
        Date startTime = calc.getCurrentTime();
        Date exitTime = Date.from(
            startTime.toInstant().plusSeconds(plannedDuration * 60L * 60)
        );
        ParkingLot lot = iDB.getParkingLot(lotid);
        ParkingPass pass = new ParkingPass(
            plateNum,
            lot.getParkingStall(stallNum),
            startTime,
            exitTime
        );
        iDB.addParkingPass(pass);
        return pass;
    }

    @Override
    public ParkingLot createLot() {

        return null;
    }

    @Override
    public ParkingStall createStall(int lotNum) {

        return null;
    }

    @Override
    public Invoice generateInvoice(int passId) {
        return null;
    }

    @Override
    public Invoice pay(int passNum, PaymentMethod paymentMethod) {

        return null;
    }

    @Override
    public User addUser(String firstName, String lastName, String email, String address, int phoneNum, String password, boolean userType) {

        return null;
    }
}
