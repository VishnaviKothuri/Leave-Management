package com.project.leaveapplication.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component

public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	    //setup Pointcuts
		@Pointcut("execution(* com.project.leaveapplication...*(..))")
		private void forAppFlow() {			
		}
		//add @Before advice
		@Before("forAppFlow()")
		public void before(JoinPoint joinPoint) throws JsonProcessingException {
			ObjectMapper mapper=new ObjectMapper();
			String methodName=joinPoint.getSignature().toShortString();
			String className=joinPoint.getClass().toString();
			Object[] arguments=joinPoint.getArgs();
			logger.info("Class :"+className);
			logger.info("method :" +methodName);
			logger.info("arguments :"+mapper.writeValueAsString(arguments));
		}
		
		//add @AfterReturning advice
		@AfterReturning(pointcut="forAppFlow()",returning="result")
		public void after(JoinPoint joinPoint) {
			String methodName=joinPoint.getSignature().getName();
			logger.info("method :"+methodName);
		}
		
	
}
