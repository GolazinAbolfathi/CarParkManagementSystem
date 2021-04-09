package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.dao.*;
import com.example.CarParkManagementSystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ParkingSystemController implements IParkingController {

    IDatabaseManager iDB = new DatabaseManager();

    @Autowired
    UsersDatabase usersDb;

    @Autowired
    Calculator calc;

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
            String username,
            String password,
            int userType) {
        // First make sure the user doesn't already exist
        List<User> ul = usersDb.getUsersByUsernameOrEmail(username, email);
        if (ul.size() > 0) {
            User u = ul.get(0);
            System.out.println("Found " + u.getFirst_name() + " " + u.getLast_name());
            return null;
        }
        System.out.println("No user found");
        User u = new User(
                firstName,
                lastName,
                email,
                address,
                phoneNum,
                username,
                password,
                userType);
        usersDb.insert(u);
        return u;
    }

    @Override
    public List<ParkingStall> getStallList() {
        ArrayList<ParkingStall> stalls = new ArrayList<>();
        System.out.println("Looking for all parking stalls");
        var lots = iDB.getParkingLots();
        for (var l : lots) {
            var s = l.getParkingStalls();
            System.out.printf("Adding %d stalls to list%n", s.size());
            stalls.addAll(s);
        }
        System.out.printf("Found %d stalls%n", stalls.size());
        return stalls;
    }

    @Override
    public User getUser(String username, String password) {
        return usersDb.getUserByUsernameAndPassword(username, password);
    }
}
