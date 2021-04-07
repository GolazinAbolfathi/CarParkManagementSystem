package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.dao.*;
import com.example.CarParkManagementSystem.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingSystemController implements IParkingController {
    IDatabaseManager iDB;
    Calculator calc;

    public ParkingSystemController() {
        calc = new Calculator();
        iDB = new TempDatabaseManager();
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

    @Override
    public List<ParkingStall> getStallList() {
        var lots = iDB.getParkingLots();
        ArrayList<ParkingStall> stalls = new ArrayList<>();
        for (var l : lots)
            stalls.addAll(l.getParkingStalls());
        return stalls;
    }
}
