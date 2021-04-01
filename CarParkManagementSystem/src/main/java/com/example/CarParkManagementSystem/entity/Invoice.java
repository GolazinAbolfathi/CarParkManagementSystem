package com.example.CarParkManagementSystem.entity;

import com.carpark.controller.Calculator;

import java.util.Date;

public class Invoice {
    private final ParkingPass pass;
    private final Date leavingTime;
    private PaymentMethod method;
    private boolean paid;

    public Invoice (ParkingPass pass, Date leavingTime) {
        this.pass = pass;
        this.leavingTime = leavingTime;
    }

    public ParkingPass getPass() {
        return pass;
    }

    public PaymentMethod getPaymentMethod() {
        return method;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getCost() {
        Calculator calc = pass.getParkingStall().getParkingLot().getCalculator();
        int hoursModifier = 1000 * 60 * 60;
        long regular = pass.getExpectedExit().getTime() - pass.getEntryTime().getTime();
        regular /= hoursModifier;
        long overtime = 0;
        if (leavingTime.after(pass.getExpectedExit())) {
            overtime = leavingTime.getTime() - pass.getExpectedExit().getTime();
            overtime /= hoursModifier;
        }
        return calc.calculateCost((int)regular, (int)overtime);
    }
}
