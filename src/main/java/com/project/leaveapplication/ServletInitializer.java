package com.project.leaveapplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//SpringBootServletInitializer class also allows us to configure our application when it's run by the servlet container, by overriding the configure() method.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LeaveApplication.class);
	}

}
