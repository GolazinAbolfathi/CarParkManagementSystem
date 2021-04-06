package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.model.NewUser;

public interface IDatabaseManager {
//    public ParkingPass getParkingPass(int passID);
//
//    public ParkingLot getParkingLot(int parkingLotID);
//
//    public ParkingStall getParkingStall(int stallID);
//
//    public Invoice getInvoice(int invoiceID);

    public NewUser getUser(int user_id);

    public void createUser(NewUser newUser);

//    public void addParkingPass(ParkingPass pass);
//
//    public void addParkingStall(ParkingStall stall);
//
//    public void addParkingLot(ParkingLot lot);
//
//    public void addInvoice(Invoice invoice);
}
