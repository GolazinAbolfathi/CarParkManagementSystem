package com.example.CarParkManagementSystem.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingLotTest {

    @Test
    void addParkingStall() {
        ParkingLot lot = new ParkingLot();
        ParkingStall stall1 = lot.addParkingStall();
        ParkingStall stall2 = lot.addParkingStall();
        ParkingStall stall3 = lot.addParkingStall();
        assertAll("Verify stall numbers increment properly",
                () -> assertEquals(stall1.getStallNumber(), 1),
                () -> assertEquals(stall2.getStallNumber(), 2),
                () -> assertEquals(stall3.getStallNumber(), 3)
        );
    }
}