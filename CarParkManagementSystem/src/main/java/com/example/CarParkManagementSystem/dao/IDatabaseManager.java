package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.User;
import com.example.CarParkManagementSystem.entity.*;

public interface IDatabaseManager {

    public User getUser(int userID);

    public void createUser(User user);
    
    public ParkingPass getParkingPass(int passID);

    public ParkingLot getParkingLot(int parkingLotID);

    public ParkingStall getParkingStall(int stallID);

    public Invoice getInvoice(int invoiceID);

    public void addParkingPass(ParkingPass pass);

    public void addParkingStall(ParkingStall stall);

    public void addParkingLot(ParkingLot lot);

    public void addInvoice(Invoice invoice);
}
