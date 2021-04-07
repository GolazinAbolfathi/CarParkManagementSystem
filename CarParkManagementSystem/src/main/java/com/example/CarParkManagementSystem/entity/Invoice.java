package com.example.CarParkManagementSystem.entity;

import com.example.CarParkManagementSystem.controller.Calculator;

import java.util.Date;

public class Invoice {
    private final ParkingPass pass;
    private final Date leavingTime;
    private PaymentMethod method;
    private boolean paid;
    private final double cost;

    public Invoice (ParkingPass pass, Date leavingTime, double cost) {
        this.pass = pass;
        this.leavingTime = leavingTime;
        this.cost = cost;
    }

    public ParkingPass getPass() {
        return pass;
    }

    public PaymentMethod getPaymentMethod() {
        return method;
    }

    public Date getLeavingTime() {
        return leavingTime;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getCost() {
        return cost;
    }

    public void pay(PaymentMethod method) {
        this.method = method;
        this.paid = true;
    }
}
