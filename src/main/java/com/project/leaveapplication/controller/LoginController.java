package com.project.leaveapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

@RequestMapping(value = "/homePage")
public ModelAndView showHomePage() {
	String name = "Kaushik";
	return new ModelAndView("home","name",name);
}

}
