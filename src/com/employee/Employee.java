package com.employee;

// This class represents an employee
public class Employee {
	int empId;
	String empName;
	String grade;
	// Parameterized constructor
	public Employee(int empId, String empName, String grade) {
		this.empId = empId;
		this.empName = empName;
		this.grade = grade;
	}
	// Getters and setters
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "empId = " + empId + ", empName = " + empName + ", grade = " + grade;
	}
}
