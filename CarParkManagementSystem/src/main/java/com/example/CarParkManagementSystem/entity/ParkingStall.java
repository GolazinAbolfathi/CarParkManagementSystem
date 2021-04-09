package com.example.CarParkManagementSystem.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingStall {
    private int parkingLot;
    private int stallNumber;
    public List<ParkingPass> getPasses() {
		return passes;
	}

	public void setPasses(ArrayList<ParkingPass> passes) {
		this.passes = passes;
	}

	public void setParkingLot(int parkingLot) {
		this.parkingLot = parkingLot;
	}

	public void setStallNumber(int stallNumber) {
		this.stallNumber = stallNumber;
	}

	private List<ParkingPass> passes;

    public ParkingStall() {
    }

    public ParkingStall(ParkingLot parkingLot) {
        this.parkingLot = parkingLot.getLotNumber();
        this.stallNumber = parkingLot.getStallCount() + 1;
        passes = new ArrayList<>();
    }

    public int getParkingLot() {
        return parkingLot;
    }

    public ParkingPass getParkingPass(int passId) {
        for (ParkingPass pass : passes)
            if (pass.getPassId() == passId)
                return pass;
        return null;
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

    public Date getNextExpectedAvailable() {
        for (ParkingPass pass : passes)
            if (!pass.isCompleted())
                return pass.getExpectedExit();
        return Date.from(Instant.now());
    }

    public ParkingPass parkCar(String plate, int minutes) {
        return parkCar(plate, Date.from(Instant.now().plusSeconds(60L * minutes)));
    }
    public ParkingPass parkCar(String plate, Date end) {
        return parkCar(plate, Date.from(Instant.now()), end);
    }
    public ParkingPass parkCar(String plate, Date start, Date end) {
        ParkingPass pass = new ParkingPass(plate, this, start, end);
        passes.add(pass);
        return pass;
    }
}
