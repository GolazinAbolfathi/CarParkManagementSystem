package com.example.CarParkManagementSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "lots")
public class ParkingLot {
    // Mongo ID
    @Id
    private String id;
    public void setId(String id) { this.id = id; }
    public String getId() { return id; }
    @Transient
    private static int nextId = 0;
    private int lotNumber;
    private List<ParkingStall> stalls;
    public void setStalls(List<ParkingStall> stalls) {
        this.stalls = stalls;
        this.stalls.forEach(stall -> stall.setParkingLot(lotNumber));
    }

    public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		ParkingLot.nextId = nextId;
	}
	public ParkingLot() { this(nextId++); }
    public ParkingLot(int lotId) {
        this.lotNumber = lotId;
        stalls = new ArrayList<>();
    }
    public void setLotNumber(int id) {
    	this.lotNumber = id;
    }
    public int getLotNumber() {
        return lotNumber;
    }

    public int getStallCount() {
        return stalls.size();
    }

    public List<ParkingStall> getParkingStalls() {
        return new ArrayList<>(stalls);
    }

    public ParkingStall getParkingStall(int stallNumber) {
        for (ParkingStall ps : stalls)
            if (ps.getStallNumber() == stallNumber)
                return ps;
        return null;
    }

    public List<ParkingStall> getAvailableStalls() {
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
