package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.model.User;

public interface IDatabaseManager {
//    public ParkingPass getParkingPass(int passID);
//
//    public ParkingLot getParkingLot(int parkingLotID);
//
//    public ParkingStall getParkingStall(int stallID);
//
//    public Invoice getInvoice(int invoiceID);

    public User getUser(int user_id);

    public void createUser(User user);

//    public void addParkingPass(ParkingPass pass);
//
//    public void addParkingStall(ParkingStall stall);
//
//    public void addParkingLot(ParkingLot lot);
//
//    public void addInvoice(Invoice invoice);
}
