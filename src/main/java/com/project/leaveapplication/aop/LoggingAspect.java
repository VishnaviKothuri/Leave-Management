package com.project.leaveapplication.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(*com.project.leaveapplication.service.EmployeeService.getAllEmployees(..))")
	public void logBeforGetAllEmployees(JoinPoint joinPoint) {
		logger.info("getEmployees method called");
		logger.debug("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		
	}
}
