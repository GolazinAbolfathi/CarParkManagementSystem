package com.example.CarParkManagementSystem.entity;

import com.example.CarParkManagementSystem.controller.Calculator;
import com.example.CarParkManagementSystem.dao.DatabaseManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot {
    private static int nextId = 0;
    private int lotId;
    private List<ParkingStall> stalls;

    public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		ParkingLot.nextId = nextId;
	}
	public List<ParkingStall> getStalls() {
		return stalls;
	}
	public void setStalls(List<ParkingStall> stalls) {
		this.stalls = stalls;
	}
	public ParkingLot() { this(nextId++); }
    public ParkingLot(int lotId) {
        this.lotId = lotId;
        stalls = new ArrayList<>();
    }
    public void setLotId(int id) {
    	this.lotId = id;
    }
    public int getLotId() {
        return lotId;
    }

    public int getStallCount() {
        return stalls.size();
    }

    public List<ParkingStall> getParkingStalls() {
        //return new ArrayList<>(stalls);
    	DatabaseManager dbm = new DatabaseManager();
    return dbm.getStalls();
    }

    public ParkingStall getParkingStall(int stallNumber) {
        for (ParkingStall ps : stalls)
            if (ps.getStallNumber() == stallNumber)
                return ps;
        return null;
    }

    public List<ParkingStall> getAvailableStalls(){
        ArrayList<ParkingStall> openStall = new ArrayList<>();
        for (ParkingStall ps : stalls)
            if(ps.isAvailable())
                openStall.add(ps);
        return openStall;
    }

    public List<ParkingPass> getParkingPasses(String plateNo) {
        ArrayList<ParkingPass> passes = new ArrayList<>();
        for (ParkingStall ps : stalls)
            passes.addAll(ps.getParkingPasses(plateNo));
        return passes;
    }

    public List<ParkingPass> getParkingPasses(Date date) {
        ArrayList<ParkingPass> passes = new ArrayList<>();
        for (ParkingStall ps : stalls)
            passes.addAll(ps.getParkingPasses(date));
        return passes;
    }

    public ParkingStall addParkingStall() {
        ParkingStall stall = new ParkingStall(this);
        stalls.add(stall);
        return stall;
    }
}
