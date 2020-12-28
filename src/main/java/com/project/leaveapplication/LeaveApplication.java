package com.project.leaveapplication;

 



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.leaveapplication.repository.LeaveRepository;






@SpringBootApplication
public class LeaveApplication implements CommandLineRunner {
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  LeaveRepository leaveRepository;
	public static void main(String[] args) {
		SpringApplication.run(LeaveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}
}
