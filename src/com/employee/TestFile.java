package com.employee;

import java.io.*;
import java.util.Scanner;

// This class is used to test the Employee class
public class TestFile {
	// This method checks if the grade is valid
	public static boolean isValidGrade(String grade) {
		return grade.equals("U1") || grade.equals("U2") || grade.equals("U3") || grade.equals("U4")
                || grade.equals("P1") || grade.equals("P2");
	}
	// This method validates the grade and throws an exception if the grade is invalid
	public static void validateGrade(String grade) throws InvalidGradeException {
		if (!isValidGrade(grade)) {
			throw new InvalidGradeException("Invalid grade: " + grade);
		}
	}

	// ...

	// This method writes employee details to a file
	public static void writeEmployees(Employee[] employees) {
		// Write employee details to a file
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("empdetails.txt"));
			for (Employee employee : employees) {
				writer.writeObject(employee.toString());
			}
			writer.close();
			System.out.println("Employee details written to empdetails.txt");
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	// This method reads employee details from a file
	public static void readEmployees() {
		// Read employee details from a file
		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("empdetails.txt"));
			System.out.println("Employee details from empdetails.txt:");
			while (true) {
				try {
					String employeeDetails = (String) reader.readObject();
					System.out.println(employeeDetails);
				} catch (EOFException e) {
					break;
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading from file: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	// This is the main method
	public static void main(String[] args) {
		// Input number of employees
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of employees: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		Employee[] emp = new Employee[n];
		int empId;
		String empName;
		String grade;

		//  Input employee details
		for (int i = 0; i < n; i++) {
			System.out.println("Enter employee details for employee #" + (i + 1) + ":");
			System.out.println("Enter employee id: ");
			empId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter employee name: ");
			empName = sc.nextLine();
			System.out.println("Enter employee grade(U1, U2, U3, U4, P1, P2): ");
			grade = sc.nextLine();
			// Validate grade
			try {
				validateGrade(grade);
				emp[i] = new Employee(empId, empName, grade);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Please enter valid grade from list U1, U2, U3, U4, P1, P2).\n");
				i--;
			}

		}
		// Write employee details to a file
		writeEmployees(emp);
		// Read employee details from a file
		readEmployees();
		
	}
}
