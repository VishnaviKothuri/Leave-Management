package com.project.leaveapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
@RequestMapping(value = "/addLeave", method = RequestMethod.GET)
public ModelAndView addLeave() {
ModelAndView mav = new ModelAndView("applyLeave");
mav.addObject("typesofLeaves",leaveService.findAllTypesofLeaves() );
mav.addObject("leaveEntry", new LeaveRecords());
return mav;

}



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

}
