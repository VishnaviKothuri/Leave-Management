package com.project.leaveapplication.service;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 //validating the employee leaves before save operation
      if(isLeaveValid(leaveRecords,employeeId)) { 
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


//checks whether employee has enough leaves to register the leave.
private boolean isLeaveValid(LeaveRecords leaveRecords, Long employeeId) {
	
    
	leaveRecords.setNoOfDays(countDays(leaveRecords.getFromDate(),leaveRecords.getTodate()));//set no of days based on from date and to date
	 
	return	 leavesUsedByEmployee(leaveRecords.getLeaveType().getId(), employeeId,getCurrentQuarter()) //employee balance leaves
	    	 < leaveRecords.getLeaveType().getNoOfLeaves()  // total leaves 
	    	 && leaveRecords.getNoOfDays()                  
	    	 <=  leaveRecords.getLeaveType().getNoOfLeaves() 
	    	 && isWeekday(leaveRecords.getFromDate())
	    	 && isWeekday(leaveRecords.getTodate());
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



//returns total earned leaves according to company policy
public int getEarnedLeaves() {
	return leaveTypeRepository.findById((long) 1000).get().getNoOfLeaves();
}

//returns total earned leaves according to company policy
public int getSickLeaves() {
	return leaveTypeRepository.findById((long) 1001).get().getNoOfLeaves();
}

//returns the pending leaves
public  List<LeaveRecords> getLeaveRequests() {
	
	return leaveRepository.findPendingLeaves();
}


public List<LeaveRecords> getEmployeeLeavesHistory(Long employeeId) {
	System.out.println("leaveHistory:"+leaveRepository.findEmployeeLeaveHistory(employeeId));
	return leaveRepository.findEmployeeLeaveHistory(employeeId);
}


public  List<LeaveRecords> getApprovedLeaves() {
	
	return leaveRepository.findApprovedLeaves();
}


public  List<LeaveRecords> getRejectedLeaves() {
	
	return leaveRepository.findRejectedLeaves();
}

//calculates the number of days
public Integer countDays(Date startDate, Date endDate) {
	
	long diff=endDate.getTime()-startDate.getTime();
	return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
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

//returns true if the given date is in weekday
private boolean isWeekday(Date date) {

	Calendar myDate = Calendar.getInstance(); 
	myDate.setTime(date);
	myDate.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
	int day = myDate.get (Calendar.DAY_OF_WEEK);
	return ((day >= Calendar.MONDAY) && (day <= Calendar.FRIDAY));
	
}

public void addLeaveType(LeaveType leaveType) {
	
	leaveTypeRepository.save(leaveType);
	
	
}

}
