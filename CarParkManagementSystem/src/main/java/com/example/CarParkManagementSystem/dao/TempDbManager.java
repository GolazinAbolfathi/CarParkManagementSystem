package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.*;

import java.util.ArrayList;

public class TempDbManager implements IDatabaseManager {
    private final ArrayList<ParkingLot> lots = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public User getUser(int userID) {
        for (User u : users)
            if (u.getUserId() == userID)
                return u;
        return null;
    }

    @Override
    public void createUser(User user) {
        // Make sure the user id doesn't conflict
        user.setUserId(users.get(users.size() - 1).getUserId() + 1);
        users.add(user);
    }

    @Override
    public ParkingPass getParkingPass(int passID) {
        for (var lot : lots)
            for (var stall : lot.getParkingStalls()) {
                ParkingPass pass = stall.getParkingPass(passID);
                if (pass != null)
                    return pass;
            }
        return null;
    }

    @Override
    public ParkingLot getParkingLot(int parkingLotID) {
        for (var lot : lots)
            if (lot.getLotId() == parkingLotID)
                return lot;
        return null;
    }

    @Override
    public Invoice getInvoice(int passId) {
        ParkingPass pass = getParkingPass(passId);
        if (pass != null)
            return pass.getInvoice();
        return null;
    }

    @Override
    public void addParkingPass(ParkingPass pass) {
        // Make sure the parking lot has already been added
        ParkingLot lot = getParkingLot(
                pass.getParkingStall().getParkingLot().getLotId()
        );
        if (lot == null) {
            lot = pass.getParkingStall().getParkingLot();
            addParkingLot(lot);
        }
        // Make sure the parking stall has already been added
        ParkingStall stall = lot.getParkingStall(pass.getParkingStall().getStallNumber());
        if (stall == null) {
            stall = pass.getParkingStall();
            addParkingStall(stall);
        }

        // If the pass isn't added by now you fucked up
    }

    @Override
    public void addParkingStall(ParkingStall stall) {

    }

    @Override
    public void addParkingLot(ParkingLot lot) {
        lots.add(lot);
    }

    @Override
    public void addInvoice(Invoice invoice) {
        // Don't feel like it
    }
}
