package com.project.leaveapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.model.LeaveRecords;
import com.project.leaveapplication.model.LeaveType;
import com.project.leaveapplication.repository.LeaveRepository;
import com.project.leaveapplication.repository.LeaveTypeRepository;

@Service
public class LeaveService {
@Autowired
LeaveTypeRepository leaveTypeRepository;
@Autowired
LeaveRepository leaveRepository;
@Autowired
EmployeeService employeeService;

public List<LeaveType> findAllTypesofLeaves(){
	return leaveTypeRepository.findAll();
}

public void saveEmployeeLeaves(LeaveRecords leaveRecords) {
	 leaveRepository.save(leaveRecords);
}

public void saveLeave(Long employeeId, LeaveRecords leaveRecords) {
  Optional<Employee> optionalEmployee = employeeService.findByEmployeeId(employeeId);
  Employee employee = optionalEmployee.get();
  employee.addLeave(leaveRecords);
  leaveRecords.setEmployee(employee);
  leaveRepository.save(leaveRecords);
  
  
	
}


}
