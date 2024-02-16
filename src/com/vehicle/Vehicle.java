package com.vehicle;

abstract class Vehicle {
	int vehicleNo;
	String engineStatus;
	int currentGear;
	
	public Vehicle(int vehicleNo, String engineStatus, int currentGear) {
        this.vehicleNo = vehicleNo;
        this.engineStatus = engineStatus;
        this.currentGear = currentGear;
    }
	
	abstract void ignite();
	abstract int changeGear(int flag);
	abstract void stop();
}
