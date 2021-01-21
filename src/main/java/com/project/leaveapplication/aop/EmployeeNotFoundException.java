package com.project.leaveapplication.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 8848249271018434921L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
