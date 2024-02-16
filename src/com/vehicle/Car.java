package com.vehicle;

// This class represents a car
public class Car extends Vehicle {
	boolean powerSteering;
	String fuelType;
	
	public Car(int vehicleNo, String engineStatus, int currentGear, boolean powerSteering, String fuelType) {
		super(vehicleNo, engineStatus, currentGear);
		this.powerSteering = powerSteering;
		this.fuelType = fuelType;
	}
	
	// Show car details
	public void showCarDetails() {
		System.out.println("*****Car Details*****");
		System.out.println("Vehicle No: " + vehicleNo);
        System.out.println("Engine Status: " + engineStatus);
        System.out.println("Current Gear: " + currentGear);
        System.out.println("Power Steering: " + powerSteering);
        System.out.println("Fuel Type: " + fuelType);
    }
	
	@Override
	public void ignite() {
		engineStatus = "ON";
		currentGear = 1;
		System.out.println("*****Car is ignited*****");
		System.out.print("Current Gear: " + currentGear + " ");
		System.out.print("Engine Status: " + engineStatus + "\n");
	}
	
	@Override
	public void stop() {
		engineStatus = "OFF";
		currentGear = 0;
		System.out.println("*****Car is stopped*****");
		System.out.print("Current Gear: " + currentGear + " ");
		System.out.print("Engine Status: " + engineStatus + "\n");
	}
	
	@Override
	public int changeGear(int flag) {
		if (flag == 1) {
			if (currentGear < 6) {
				currentGear++;
				System.out.println("Gear changed to " + currentGear);
			}
		} else if (flag == -1) {
			if (currentGear > 1) {
				currentGear--;
				System.out.println("Gear changed to " + currentGear);
			}
		}
		return currentGear;
	}
}
