package com.example.CarParkManagementSystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingStall {
    private final ParkingLot parkingLot;
    private final int stallNumber;
    private final ArrayList<ParkingPass> passes;

    public ParkingStall(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.stallNumber = parkingLot.getStallCount() + 1;
        passes = new ArrayList<>();
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public List<ParkingPass> getParkingPasses() {
        return new ArrayList<>(passes);
    }

    public List<ParkingPass> getParkingPasses(String plate) {
        ArrayList<ParkingPass> pps = new ArrayList<>();
        for (ParkingPass pass : passes)
            if (pass.getCarPlate().equals(plate))
                pps.add(pass);
        return pps;
    }

    public List<ParkingPass> getParkingPasses(Date date) {
        ArrayList<ParkingPass> pps = new ArrayList<>();
        int daysModifier = 1000 * 60 * 60 * 24;
        long searchTime = date.getTime() / daysModifier;
        for (ParkingPass pass : passes) {
            long passTime = pass.getEntryTime().getTime();
            passTime /= daysModifier;
            if (searchTime == passTime)
                pps.add(pass);
        }
        return pps;
    }

    public int getStallNumber() {
        return stallNumber;
    }

    public boolean isAvailable() {
        for (ParkingPass pass : passes)
            if (!pass.isCompleted())
                return false;
        return true;
    }

    public ParkingPass parkCar(String plate, Date start, Date end) {
        ParkingPass pass = new ParkingPass(plate, this, start, end);
        passes.add(pass);
        return pass;
    }
}
