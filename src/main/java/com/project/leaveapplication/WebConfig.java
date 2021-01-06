package com.project.leaveapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

	public void configureDefaultServletHandling(
	        DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}
	@Bean
	   public ViewResolver viewResolver() {
	      InternalResourceViewResolver bean = new InternalResourceViewResolver();
	      bean.setPrefix("/WEB-INF/views/");
	      bean.setSuffix(".jsp");
	      return bean;
	   }
	
	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry
	      .addResourceHandler("/resources/**")
	      .addResourceLocations("/resources/","/other-resources/")
	      .setCachePeriod(3600)
	      .resourceChain(true)
	      .addResolver(new PathResourceResolver());
   }
}
