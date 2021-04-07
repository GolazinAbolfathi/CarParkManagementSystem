package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.dao.*;
import com.example.CarParkManagementSystem.entity.*;

import java.time.Instant;
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
        ParkingLot lot = new ParkingLot();
        iDB.addParkingLot(lot);
        return lot;
    }

    @Override
    public ParkingStall createStall(int lotNum) {
        return iDB.getParkingLot(lotNum).addParkingStall();
    }

    @Override
    public Invoice generateInvoice(int passId) {
        ParkingPass pass = iDB.getParkingPass(passId);
        Invoice i = null;
        if (pass != null)
            i = pass.generateInvoice(
                    calc.getCurrentTime(),
                    calc.calculateCost(pass)
            );
        return i;
    }

    @Override
    public Invoice pay(int passId, PaymentMethod paymentMethod) {
        ParkingPass pass = iDB.getParkingPass(passId);
        Invoice iv = pass.getInvoice();
        iv.getCost(); // Don't do anything with the cost rn lmao xD
        // -- Charge the cash money here --
        iv.pay(paymentMethod);
        return iv;
    }

    @Override
    public User addUser(
            String firstName,
            String lastName,
            String email,
            String address,
            String phoneNum,
            String password,
            int userType) {
        User u = new User(
                firstName,
                lastName,
                email,
                address,
                phoneNum,
                password,
                userType);
        iDB.createUser(u);
        return u;
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
