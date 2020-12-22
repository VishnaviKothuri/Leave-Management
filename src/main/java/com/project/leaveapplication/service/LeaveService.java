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


//add leave records
public boolean saveLeave(Long employeeId, LeaveRecords leaveRecords) {
	
      if(leavesUsedByEmployee(leaveRecords.getLeaveType().getId(), employeeId,leaveRecords.getQuarter()) 
    	 < leaveRecords.getLeaveType().getNoOfLeaves()) {
    	  
	  Optional<Employee> optionalEmployee = employeeService.findByEmployeeId(employeeId);
	  Employee employee = optionalEmployee.get();
	  employee.addLeave(leaveRecords);
	  leaveRecords.setEmployee(employee);
	  leaveRepository.save(leaveRecords);
	  return true;
	  
      }
      else
      {
    	  return false;
      }
}



public LeaveRecords getLeaveDetailsOnId(Long leaveId) {
	Optional<LeaveRecords> leave= leaveRepository.findById(leaveId);
	LeaveRecords leaveRecords= leave.get();
	return leaveRecords;
}



//update leave records(accept and reject).
public void updateLeaveDetails(LeaveRecords leaveRecord) {
leaveRepository.save(leaveRecord);
	
}

//Retrieving no of leaves used by employee on current quarter.
public int leavesUsedByEmployee(Long leaveTypeId,Long employeeId,String quarterMonth) {
return leaveRepository.getLeavesUsedByEmployee(leaveTypeId, employeeId,quarterMonth );
}

//Retrieving the count of balance earned leaves of the employee
public int balanceEarnedLeaves(Long employeeId) {
	return 0;
}

//Retrieving the count of balance sick leaves of the employee
public int balanceSickLeaves(Long employeeId) {
	return 0;
}



}
