package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.entity.Invoice;
import com.example.CarParkManagementSystem.entity.ParkingPass;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class Calculator {
    private final double hourly;
    private final double overtime;

    public Calculator() {
        this(5.0);
    }
    public Calculator(double hourly) {
        this(hourly, hourly * 1.5);
    }
    public Calculator(double hourly, double overtime) {
        this.hourly = hourly;
        this.overtime = overtime;
    }

    public double calculateCost(int regular, int overtime) {
        double regCost = regular * hourly;
        double overCost = overtime * this.overtime;
        return regCost + overCost;
    }

    public double calculateCost(ParkingPass pass) {
        return calculateCost(pass, getCurrentTime());
    }
    public double calculateCost(ParkingPass pass, Date exit) {
        int hoursMod = 1000 * 60 * 60;
        long regular = pass.getExpectedExit().getTime() - pass.getEntryTime().getTime();
        regular /= hoursMod;
        long overtime = 0;
        if (exit.after(pass.getExpectedExit())) {
            overtime = exit.getTime() - pass.getExpectedExit().getTime();
            overtime /= hoursMod;
        }
        return calculateCost((int)regular, (int)overtime);
    }

    public Date getCurrentTime() {
        return Date.from(Instant.now());
    }
}
