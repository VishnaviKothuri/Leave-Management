package com.project.leaveapplication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.model.Role;
import com.project.leaveapplication.model.dto.EmployeeRoleDTO;
import com.project.leaveapplication.service.EmployeeService;
import com.project.leaveapplication.service.RoleService;


@Controller
public class RoleController {
@Autowired
EmployeeService employeeService;
@Autowired
RoleService roleService;


	
@RequestMapping(value = "/addRole", method = RequestMethod.GET)
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView displayAddRoleForm(@RequestParam Long employeeId) {
	
	ModelAndView mav = new ModelAndView("addRole");
	Optional<Employee> optionalEmployee = employeeService.findByEmployeeId(employeeId);
	Employee employee = optionalEmployee.get();
	mav.addObject("title","Add Role to:"+ employee);
	mav.addObject("roles", roleService.findAllRoles());
	mav.addObject("employee", employee);
	EmployeeRoleDTO employeeRole = new EmployeeRoleDTO();
	employeeRole.setEmployee(employee);
	mav.addObject("employeeRole",employeeRole);
	return mav;
	
}


@RequestMapping(value = "/addRole", method = RequestMethod.POST)
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView addRoleToEmployee(@ModelAttribute("employeeRole")  EmployeeRoleDTO employeeRole) {

	Employee employee = employeeRole.getEmployee();
	Role role = employeeRole.getRole();
	employee.addRole(role);
	employeeService.saveEmployee(employee);
	return null;
}

}
