package com.employee;

// This class defines a custom exception
public class InvalidGradeException extends Exception {
	public InvalidGradeException(String message) {
		super(message);
	}
}
