package com.project.leaveapplication.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.service.EmployeeService;
import com.project.leaveapplication.service.RoleService;

@Controller
public class RegistrationController {
@Autowired
EmployeeService employeeService;
@Autowired
RoleService roleService;

    
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
	public ModelAndView showRegistrationPage() {
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("employee", new Employee());
		modelAndView.addObject("roles", roleService.findAllRoles());
		return modelAndView;	
	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
	public ModelAndView registerEmployee(@Valid  @ModelAttribute("employee")  Employee employee,  BindingResult res) {
		employee.setStatus(1);
		if(res.hasErrors()) {
	
			return new ModelAndView("register","roles", roleService.findAllRoles());
		}
		
		
		else if( employeeService.saveEmployee(employee)) {
			
			return new ModelAndView("redirect:/home");
		}
		
		
		else
		{
			return new ModelAndView("register","message","email id exists");
		}
		
	}
	
	
	
	
}
