package com.project.leaveapplication.service;
import java.util.Calendar;
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
	  leaveRecords.setQuarter(getCurrentQuarter());
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
	return getEarnedLeaves()-leaveRepository.getEarnedLeavesById(employeeId,getCurrentQuarter());
	
}


//Retrieving the count of balance sick leaves of the employee
public int balanceSickLeaves(Long employeeId) {
	return getSickLeaves()-leaveRepository.getsickLeavesById(employeeId,getCurrentQuarter());
}


//delete leave
public boolean deleteLeave(Long leaveId) {
	Optional<LeaveRecords> optionalLeaveRecords = leaveRepository.findById(leaveId);
	LeaveRecords  leaveRecord = optionalLeaveRecords.get();
	if(leaveRecord!=null) {
		leaveRepository.delete(leaveRecord);
		return true;
	}
	else {
		return false;
	}
	
}


//returns the current quarter of the month.
public String getCurrentQuarter() {
	Calendar calendar = Calendar.getInstance();
	int month = calendar.get(Calendar.MONTH);

	return (month >= Calendar.JANUARY && month <= Calendar.MARCH)     ? "Q1" :
	       (month >= Calendar.APRIL && month <= Calendar.JUNE)        ? "Q2" :
	       (month >= Calendar.JULY && month <= Calendar.SEPTEMBER)    ? "Q3" :
	                                                                    "Q4";			
}
//returns total earned leaves according to company policy
public int getEarnedLeaves() {
	return leaveTypeRepository.findById((long) 1000).get().getNoOfLeaves();
}

//returns total earned leaves according to company policy
public int getSickLeaves() {
	return leaveTypeRepository.findById((long) 1001).get().getNoOfLeaves();
}


public  List<LeaveRecords> getLeaveRequests() {
	
	return leaveRepository.findAll();
}


public List<LeaveRecords> getEmployeeLeavesHistory(Long employeeId) {
	
	return leaveRepository.findEmployeeLeaveHistory(employeeId);
}





}
