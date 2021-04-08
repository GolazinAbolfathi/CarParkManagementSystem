package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.User;
import com.example.CarParkManagementSystem.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDatabaseManager {

    User getUser(int userID);

    void createUser(User user);
    
    ParkingPass getParkingPass(int passID);

    ParkingLot getParkingLot(int parkingLotID);

    List<ParkingLot> getParkingLots();

    Invoice getInvoice(int invoiceID);

    void addParkingPass(ParkingPass pass);

    void addParkingStall(ParkingStall stall);

    void addParkingLot(ParkingLot lot);

    void addInvoice(Invoice invoice);
}
