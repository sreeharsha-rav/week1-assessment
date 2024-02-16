package com.vehicle.test;

import java.util.Scanner;

import com.vehicle.Car;

// This class tests the Car class
public class TestVehicle {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Vehicle number input
        int vehicleNo = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter the vehicle number: ");
            vehicleNo = sc.nextInt();
			if (vehicleNo >= 0) {
				isValid = true;
			} else {
				System.out.println("Invalid input! Please enter a valid vehicle number.");
				sc.next(); // Consume the invalid input
			}
        }

        sc.nextLine(); // Consume newline

        // Fuel type input
        String fuelType = "";
        isValid = false;
        while (!isValid) {
            System.out.println("Enter the fuel type (Gas/Petrol/Diesel): ");
            fuelType = sc.nextLine().trim().toLowerCase();
            if (fuelType.equals("gas") || fuelType.equals("petrol") || fuelType.equals("diesel")) {
                isValid = true;
            } else {
                System.out.println("Invalid input! Please enter Gas, Petrol, or Diesel as fuel type.");
            }
        }
        
        // Power steering input
        boolean powerSteering = false;
        isValid = false;
        while (!isValid) {
			System.out.println("Does the car have power steering? (Yes/No): ");
			String input = sc.nextLine().trim().toLowerCase();
			if (input.equals("yes")) {
				powerSteering = true;
				isValid = true;
			} else if (input.equals("no")) {
				powerSteering = false;
				isValid = true;
			} else {
				System.out.println("Invalid input! Please enter Yes or No.");
			}
        }
		
		// Create an object of Car
        Car car = new Car(vehicleNo, "OFF", 0, powerSteering, fuelType);
        car.showCarDetails();	// Show car details
        car.ignite(); // Start the car
        // Increase the gear
		for (int i = 0; i < 7; i++) {
			car.changeGear(1);
		}
		// Decrease the gear
		for (int i = 0; i < 7; i++) {
			car.changeGear(-1);
		}
        car.stop(); // Stop the car
	}
}
