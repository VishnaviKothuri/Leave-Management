package com.project.leaveapplication.controller;

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
public ModelAndView showHomePage() {
	return new ModelAndView("home");
}

@RequestMapping(value = "/managerHome")
public ModelAndView showManagerHomePage() {
	return new ModelAndView("managerHome");
}

@RequestMapping(value = "/employeeHome")
public ModelAndView showEmployeeHomePage() {
	return new ModelAndView("employeeHome");
}

}
