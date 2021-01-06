package com.project.leaveapplication.service;

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

public Boolean saveEmployee(Employee employee) {
 
  if(emailExist(employee.getEmail())) {
	return false;
  }
  employeeRepository.save(employee);
  return true;
}



public Optional<Employee> findByEmployeeId(Long employeeId) {
	return employeeRepository.findById(employeeId);
}



public boolean updateStatusOfEmployee(Long employeeId) {
Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
Employee employee = optionalEmployee.get();
if(employee!=null) {
employee.setStatus(0);
saveEmployee(employee);
return true;
}
else {
return false;
}


	
}



public List<Employee> getAllEmployees() {
	return employeeRepository.findAll();
}



public void updateEmployee(Employee employee,Long employeeId) {
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
}

private boolean emailExist(final String email) {
    final Employee user = employeeRepository.findByEmail(email);
    return user != null;
}

}
