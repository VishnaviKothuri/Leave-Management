package com.project.leaveapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.service.EmployeeService;

@Controller
public class RegistrationController {
@Autowired
EmployeeService employeeService;



	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage() {
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("employee", new Employee());
		return modelAndView;	
	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return new ModelAndView("home");
	}
	
	
	
	
}
