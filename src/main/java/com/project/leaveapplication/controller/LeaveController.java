package com.project.leaveapplication.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.leaveapplication.model.LeaveRecords;
import com.project.leaveapplication.service.LeaveService;

@Controller

public class LeaveController {
@Autowired
LeaveService leaveService;

//Returns leave registration form along with model object.
@RequestMapping(value = "/addLeave", method = RequestMethod.GET)
public ModelAndView addLeave() {
ModelAndView mav = new ModelAndView("applyLeave");
mav.addObject("typesofLeaves",leaveService.findAllTypesofLeaves() );
mav.addObject("leaveEntry", new LeaveRecords());
return mav;

}


//registering a leave
@RequestMapping(value = "/addLeave", method = RequestMethod.POST)
public ModelAndView addLeave(@RequestParam Long employeeId,@ModelAttribute("leave")LeaveRecords leaveRecords){
leaveRecords.setAcceptReject(2);
leaveRecords.setStatus(2);
if(leaveService.saveLeave(employeeId,leaveRecords)) {
	return null;
}
else {
	return null;	//return addLeave view
}

}

//accepting or rejecting a leave
@PreAuthorize("hasAuthority('MANAGER_PRIVILEGE')")
@RequestMapping(value = "/manage-leaves/{action}/{leaveId}",method=RequestMethod.GET)
public ModelAndView acceptOrRejectLeaves(@PathVariable String action,@PathVariable Long leaveId) {
	
	LeaveRecords leaveRecord = leaveService.getLeaveDetailsOnId(leaveId);
	if(action.equals("accept")) {
		leaveRecord.setAcceptReject(1);
		leaveRecord.setStatus(0);
	}else if(action.equals("reject")) {
		leaveRecord.setAcceptReject(0);
		leaveRecord.setStatus(0);	
	}
	leaveService.updateLeaveDetails(leaveRecord);
	return null;
}

//deleting a leave
@RequestMapping(value = "/cancel-leave",method=RequestMethod.POST)
public ModelAndView cancelLeave(@RequestParam Long leaveId) {
	if(leaveService.deleteLeave(leaveId)) {
		return null;//return myLeaves view
	}
	else {
		return null;//return myLeaves page with message;
	}
}

//returns employee earned and sick leave balance.
@RequestMapping(value = "/view-leave-balance/{employeeId}",method=RequestMethod.GET)
public ModelAndView viewLeaveBalance(@PathVariable Long employeeId) {
	ModelAndView mav = new ModelAndView();
	mav.addObject("earnedLeaves",leaveService.balanceEarnedLeaves(employeeId));
	mav.addObject("sickLeaves",leaveService.balanceSickLeaves(employeeId));
	return null;
	
}
//get all leave requests .
@RequestMapping(value = "/view-leaves-requests",method=RequestMethod.GET)
@PreAuthorize("hasAuthority('MANAGER_PRIVILEGE')")
public ModelAndView getLeaveRequestsOfEveryEmployee() {
	ModelAndView mav = new ModelAndView();
	mav.addObject("employeeLeaveRequests",leaveService.getLeaveRequests());
	return null;
	
}


//get all leave records of the employee.
@RequestMapping(value = "/leave-history/{employeeId}",method=RequestMethod.GET)
public ModelAndView getEmployeeLeaveHistory(@PathVariable Long employeeId) {
	ModelAndView mav = new ModelAndView();
	mav.addObject("leaveHistory", leaveService.getEmployeeLeavesHistory(employeeId));
	return null;
}

//editLeave
@RequestMapping(value = "/editLeave/{leaveId}", method = RequestMethod.GET)
public ModelAndView editLeave(@PathVariable Long leaveId) {
ModelAndView mav = new ModelAndView("applyLeave");
mav.addObject("typesofLeaves",leaveService.findAllTypesofLeaves() );
mav.addObject("leaveEntry", leaveService.getLeaveDetailsOnId(leaveId));
return mav;

}
//save changes
@RequestMapping(value = "/editLeave/{leaveId}", method = RequestMethod.POST)
public ModelAndView saveChanges(@PathVariable Long leaveId,@ModelAttribute("leave")LeaveRecords leaveRecords) {
	 
	LeaveRecords leaveRecord = leaveService.getLeaveDetailsOnId(leaveId);
	leaveRecord.setFromDate(leaveRecords.getFromDate());
	leaveRecord.setTodate(leaveRecords.getTodate());
	leaveRecord.setNoOfDays(leaveRecords.getNoOfDays());
	leaveRecord.setLeaveType(leaveRecords.getLeaveType());
	leaveRecord.setReason(leaveRecords.getReason());
	leaveService.updateLeaveDetails(leaveRecord);
	return null;
	


}
}
