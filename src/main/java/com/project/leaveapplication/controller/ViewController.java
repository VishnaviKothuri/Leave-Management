package com.project.leaveapplication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

@RequestMapping(value = "/login")
public ModelAndView showLoginPage() {
	return new ModelAndView("login");
}


@RequestMapping(value = "/home")
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public ModelAndView showHomePage() {
	return new ModelAndView("home");
}

@RequestMapping(value = "/managerHome")
@PreAuthorize("hasAuthority('MANAGER_PRIVILEGE')")
public ModelAndView showManagerHomePage() {
	return new ModelAndView("managerHome");
}

@RequestMapping(value = "/employeeHome")
@PreAuthorize("hasAuthority('EMPLOYEE_PRIVILEGE')")
public ModelAndView showEmployeeHomePage() {
	return new ModelAndView("employeeHome");
}

@RequestMapping(value = "/aboutUs")
public ModelAndView showAboutusPage() {
	return new ModelAndView("aboutUs");
}


@RequestMapping(value = "/accessDenied")
public ModelAndView showaccessDeniedPage() {
	return new ModelAndView("accessDenied");
}

@RequestMapping(value = "/leavePolicies")
public ModelAndView showleavePolicy() {
	return new ModelAndView("leavePolicies");
}

@RequestMapping(value = "/managerLeavePolicies")
public ModelAndView showManagerleavePolicy() {
	return new ModelAndView("managerLeavePolicies");
}

@RequestMapping(value = "/adminLeavePolicies")
public ModelAndView showAdminleavePolicy() {
	return new ModelAndView("adminLeavePolicies");
}


}
