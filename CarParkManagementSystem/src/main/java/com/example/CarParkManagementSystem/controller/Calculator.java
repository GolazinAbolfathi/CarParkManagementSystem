package com.example.CarParkManagementSystem.controller;

import java.time.Instant;
import java.util.Date;

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

    public Date getCurrentTime() {
        return Date.from(Instant.now());
    }
}
