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
import com.project.leaveapplication.model.LeaveType;
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
@RequestMapping(value = "/addLeave/{employeeId}", method = RequestMethod.POST)
public ModelAndView addLeave(@PathVariable Long employeeId,@ModelAttribute("leave")LeaveRecords leaveRecords){
leaveRecords.setStatus(2);
if(leaveService.saveLeave(employeeId,leaveRecords)) {
	return new ModelAndView("employeeHome");
}
    
    ModelAndView mav = new ModelAndView("applyLeave");
    mav.addObject("typesofLeaves",leaveService.findAllTypesofLeaves() );
    mav.addObject("leaveEntry", new LeaveRecords());
    mav.addObject("reason","Invalid Leave Entry");
    return mav;
    
}

//accepting or rejecting a leave
@PreAuthorize("hasAuthority('MANAGER_PRIVILEGE')")
@RequestMapping(value = "/manage-leaves/{action}/{leaveId}",method=RequestMethod.GET)
public ModelAndView acceptOrRejectLeaves(@PathVariable String action,@PathVariable Long leaveId) {
	
	LeaveRecords leaveRecord = leaveService.getLeaveDetailsOnId(leaveId);
	if(action.equals("accept")) {
		leaveRecord.setStatus(1);
	}else if(action.equals("reject")) {
		leaveRecord.setStatus(0);	
	}
	leaveService.updateLeaveDetails(leaveRecord);
	return new ModelAndView("redirect:/managerHome");
}

//deleting a leave
@RequestMapping(value = "/cancel-leave/{leaveId}/{employeeId}",method=RequestMethod.GET)
public ModelAndView cancelLeave(@PathVariable Long leaveId,@PathVariable Long employeeId) {
	ModelAndView mav = new ModelAndView("redirect:/employeeHome");
	if(leaveService.deleteLeave(leaveId)) {
		return mav;
	}
	return mav;
	
}

//returns employee earned and sick leave balance.
@RequestMapping(value = "/view-leave-balance/{employeeId}",method=RequestMethod.GET)
@PreAuthorize("#employeeId == authentication.principal.id")
public ModelAndView viewLeaveBalance(@PathVariable Long employeeId) {
	ModelAndView mav = new ModelAndView("leaveBalance");
	mav.addObject("earnedLeaves",leaveService.balanceEarnedLeaves(employeeId));
	mav.addObject("sickLeaves",leaveService.balanceSickLeaves(employeeId));
	return mav;
	
}

//get all leave requests .
@RequestMapping(value = "/view-leaves-requests",method=RequestMethod.GET)
@PreAuthorize("hasAuthority('MANAGER_PRIVILEGE')")
public ModelAndView getLeaveRequestsOfEveryEmployee() {
	ModelAndView mav = new ModelAndView("leaveRequests");
	mav.addObject("leaveRequests",leaveService.getLeaveRequests());
	return mav;
	
}
//get approved leaves
@RequestMapping(value = "/view-approved-leaves",method=RequestMethod.GET)
@PreAuthorize("hasAuthority('MANAGER_PRIVILEGE')")
public ModelAndView getApprovedLeaves() {
	ModelAndView mav = new ModelAndView("approved");
	mav.addObject("leaveRequests",leaveService.getApprovedLeaves());
	return mav;
	
}
//get rejected leaves
@RequestMapping(value = "/view-rejected-leaves",method=RequestMethod.GET)
@PreAuthorize("hasAuthority('MANAGER_PRIVILEGE')")
public ModelAndView getRejectedLeaves() {
	ModelAndView mav = new ModelAndView("rejected");
	mav.addObject("leaveRequests",leaveService.getRejectedLeaves());
	return mav;
	
}


//get all leave records of the employee.
@RequestMapping(value = "/leave-history/{employeeId}",method=RequestMethod.GET)
@PreAuthorize("#employeeId == authentication.principal.id")
public ModelAndView getEmployeeLeaveHistory(@PathVariable Long employeeId) {
	ModelAndView mav = new ModelAndView("leaveDetails");
	mav.addObject("leaveHistory", leaveService.getEmployeeLeavesHistory(employeeId));
	return mav;
}

//editLeave
@RequestMapping(value = "/editLeave/{leaveId}", method = RequestMethod.GET)
public ModelAndView editLeave(@PathVariable Long leaveId) {
ModelAndView mav = new ModelAndView("editLeave");
mav.addObject("typesofLeaves",leaveService.findAllTypesofLeaves() );
mav.addObject("leaveEntry", leaveService.getLeaveDetailsOnId(leaveId));
return mav;

}
//save changes
@RequestMapping(value = "editLeave/performEdit/{leaveId}/{employeeId}", method = RequestMethod.POST)
public ModelAndView saveChanges(@PathVariable Long leaveId,@PathVariable Long employeeId,@ModelAttribute("leave")LeaveRecords leaveRecords) {
	ModelAndView mav = new ModelAndView("/employeeHome");
	LeaveRecords leaveRecord = leaveService.getLeaveDetailsOnId(leaveId);
	leaveRecord.setFromDate(leaveRecords.getFromDate());
	leaveRecord.setTodate(leaveRecords.getTodate());
	leaveRecord.setNoOfDays(leaveRecords.getNoOfDays());
	leaveRecord.setLeaveType(leaveRecords.getLeaveType());
	leaveRecord.setReason(leaveRecords.getReason());
	leaveService.updateLeaveDetails(leaveRecord);
    return mav;
	


}


//show Leave Type page
@RequestMapping(value = "/leaveType",method=RequestMethod.GET)
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView showLeaveType() {
ModelAndView mav = new ModelAndView("leaveType");
mav.addObject("leaveType", new LeaveType());
return mav;
}

//add Leave Type
@RequestMapping(value = "/leaveType",method=RequestMethod.POST)
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView addLeaveType(@ModelAttribute("leaveType")LeaveType leaveType) {
 
  leaveService.addLeaveType(leaveType);
  ModelAndView mav = new ModelAndView("leaveType");
  mav.addObject("leaveType", new LeaveType());
  mav.addObject("message", "success");
  return mav;
  
	  
  }
	
	  
  
}

