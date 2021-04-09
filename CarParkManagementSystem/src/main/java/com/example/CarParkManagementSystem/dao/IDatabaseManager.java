package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.User;
import com.example.CarParkManagementSystem.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDatabaseManager {
    ParkingPass getParkingPass(int passID);

    ParkingLot getParkingLot(int parkingLotID);

    List<ParkingLot> getParkingLots();

    Invoice getInvoice(int invoiceID);

    void addParkingPass(ParkingPass pass);

    void addParkingStall(ParkingStall stall);

    void addParkingLot(ParkingLot lot);

    void saveParkingLot(ParkingLot lot);

    void addInvoice(Invoice invoice);
}
