package com.example.CarParkManagementSystem.model;

public class Stall {
	private int stallId;
	private String startTime;
	private int minutesLeft;
	private int parkedUnit;
	
	public Stall(int i, String string, int j, int k) {
		this.stallId = i;
		this.startTime = string;
		this.minutesLeft = j;
		this.parkedUnit = k;
	}

	public int getStallId() {
		return stallId;
	}
	public void setStallId(int stallId) {
		this.stallId = stallId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getMinutesLeft() {
		return minutesLeft;
	}
	public void setMinutesLeft(int minutesLeft) {
		this.minutesLeft = minutesLeft;
	}
	public int getParkedUnit() {
		return parkedUnit;
	}
	public void setParkedUnit(int parkedUnit) {
		this.parkedUnit = parkedUnit;
	}

}
