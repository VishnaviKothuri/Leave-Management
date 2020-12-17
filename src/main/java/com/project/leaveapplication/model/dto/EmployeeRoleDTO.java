package com.project.leaveapplication.model.dto;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.model.Role;

public class EmployeeRoleDTO {

	
	private Employee employee;
	
	private Role role;
	
	public EmployeeRoleDTO() {
		
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
