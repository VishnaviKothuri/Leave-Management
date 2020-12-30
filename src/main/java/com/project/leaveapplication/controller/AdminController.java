package com.project.leaveapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.leaveapplication.service.EmployeeService;

public class AdminController {

@Autowired
EmployeeService employeeService;
//update status of the employee	
@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView updateEmployeeStatus(@RequestParam Long employeeId) {
	
 if(employeeService.updateStatusOfEmployee(employeeId)) {
	  return null; 
 }
 else {
	  return null;
 }
	 
}
//view all employees
@RequestMapping(value = "/viewEmployees", method = RequestMethod.GET)
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView listOfEmployees() {
	ModelAndView mav = new ModelAndView("viewEmployees");
	mav.addObject("employeeDetails", employeeService.getAllEmployees());
	return null;//return employee details page
}




}
