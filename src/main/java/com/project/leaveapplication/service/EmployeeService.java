package com.project.leaveapplication.service;

import com.project.leaveapplication.aop.EmployeeNotFoundException;
import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
@Autowired
EmployeeRepository employeeRepository;
@Autowired
RoleService roleService;
//saving employee details
public Boolean saveEmployee(Employee employee) {
 
  if(emailExist(employee.getEmail())) { // checking if email id already registered returns false
	return false;
  }
  employeeRepository.save(employee);
  return true;
}



public Optional<Employee> findByEmployeeId(Long employeeId) {	
	if(employeeRepository.findById(employeeId)==null) {
		throw new EmployeeNotFoundException("Employee Not Found");
	}
	return employeeRepository.findById(employeeId);
}


//making employee inactive , if he/she is not part of an organization.
public boolean updateStatusOfEmployee(Long employeeId) {
try
{
Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
Employee employee = optionalEmployee.get();
employee.setStatus(0);//updating employee status active to inactive.
saveEmployee(employee);
return true;
}catch(Exception ex) {
	throw new EmployeeNotFoundException("Emloyee Not Found");
}	
}

//Retrieves employees details

public List<Employee> getAllEmployees() {
	return employeeRepository.findAll();
}



public void updateEmployee(Employee employee,Long employeeId) {
	try {
	Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
	Employee updateEmployee = optionalEmployee.get();
	updateEmployee.setFirstName(employee.getFirstName());
	updateEmployee.setLastName(employee.getLastName());
	updateEmployee.setEmail(employee.getEmail());
	updateEmployee.setPassword(employee.getPassword());
	updateEmployee.setDateOfJoining(employee.getDateOfJoining());
	updateEmployee.setContactNumber(employee.getContactNumber());
	updateEmployee.setGender(employee.getGender());
	saveEmployee(updateEmployee);
	}catch(Exception e) {
		throw new EmployeeNotFoundException("Emloyee Not Found");
	}
}

//method that checks  email id exists or not.
private boolean emailExist(final String email) {
    final Employee employee = employeeRepository.findByEmail(email);
    return employee != null;
}

}
