package com.example.CarParkManagementSystem.entity;

import org.springframework.data.annotation.Transient;

import java.util.Date;

public class ParkingPass {
    private int passId;
    private String carPlate;
    @Transient
    private ParkingStall stall;
    private Date enterTime;
    private Date expectedExit;
    private Invoice invoice;

    public ParkingPass() {}

    public ParkingPass(String plate, ParkingStall stall, Date enter, Date exit) {
        this.carPlate = plate;
        this.stall = stall;
        this.enterTime = enter;
        this.expectedExit = exit;
        this.invoice = null;
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public ParkingStall getParkingStall () {
        return stall;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public Date getEntryTime() {
        return enterTime;
    }

    public Date getExpectedExit() {
        return expectedExit;
    }

    public boolean isCompleted() {
        return invoice != null;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Invoice generateInvoice(Date exitTime, double cost) {
        invoice = new Invoice(this, exitTime, cost);
        return invoice;
    }
}
