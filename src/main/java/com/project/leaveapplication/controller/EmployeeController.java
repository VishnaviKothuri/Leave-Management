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

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.service.EmployeeService;
@Controller
public class EmployeeController {
@Autowired
EmployeeService employeeService;

//edit employee
@RequestMapping(value = "/editEmployee/{employeeId}", method = RequestMethod.GET)
public ModelAndView editEmployee(@PathVariable Long employeeId) {
	
	ModelAndView mav = new ModelAndView("editEmployee");
	mav.addObject("employee",employeeService.findByEmployeeId(employeeId));
	mav.addObject("id", employeeId);
	return mav;
}


//perform edit
@RequestMapping(value = "/performEdit/{employeeId}", method = RequestMethod.POST)
public ModelAndView performEdit(@ModelAttribute("employee") Employee employee,@PathVariable Long employeeId) {
	ModelAndView mav = new ModelAndView("redirect:/home");
	employeeService.updateEmployee(employee,employeeId);
	return mav;
}


//view employees
@RequestMapping(value = "/view-employees", method = RequestMethod.GET)
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView viewEmployees() {
	ModelAndView mav = new ModelAndView("employees");
	mav.addObject("employees", employeeService.getAllEmployees());
	return mav;
}


//update status of the employee	
@RequestMapping(value = "/updateStatus/{employeeId}", method = RequestMethod.GET)
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView updateEmployeeStatus(@PathVariable Long employeeId) {	
if(employeeService.updateStatusOfEmployee(employeeId)) {
	return new ModelAndView("redirect:/home");
}
    return new ModelAndView("redirect:/home");
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
