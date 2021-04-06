package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.User;
import com.example.CarParkManagementSystem.entity.*;

public class DatabaseManager implements IDatabaseManager {
    @Override
    public ParkingPass getParkingPass(int passID) {
        return null;
    }

    @Override
    public ParkingLot getParkingLot(int parkingLotID) {
        return null;
    }

    @Override
    public ParkingStall getParkingStall(int stallID) {
        return null;
    }

    @Override
    public Invoice getInvoice(int invoiceID) {
        return null;
    }

    @Override
    public User getUser(int userID) {
        return null;
    }

    @Override
    public void createUser(User user) {
        
    }

    public void addParkingPass(ParkingPass pass) {

    }

    @Override
    public void addParkingStall(ParkingStall stall) {

    }

    @Override
    public void addParkingLot(ParkingLot lot) {

    }

    @Override
    public void addInvoice(Invoice invoice) {

    }
}
