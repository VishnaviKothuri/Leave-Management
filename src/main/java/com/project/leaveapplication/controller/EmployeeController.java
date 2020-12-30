package com.project.leaveapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.service.EmployeeService;

public class EmployeeController {
@Autowired
EmployeeService employeeService;

@RequestMapping(value = "/editDetails", method = RequestMethod.GET)
public ModelAndView editEmployee(@RequestParam Long employeeId) {
	ModelAndView mav = new ModelAndView("edit");
	mav.addObject("employeeDetails",employeeService.findByEmployeeId(employeeId));
	return mav;

}

@RequestMapping(value = "/performEdit", method = RequestMethod.GET)
public ModelAndView performEdit(@ModelAttribute("employee") Employee employee) {
	employeeService.saveEmployee(employee);
	return null;//return employee details page.
}


}
