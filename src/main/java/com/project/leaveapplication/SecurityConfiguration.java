package com.project.leaveapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.project.leaveapplication.security.EmployeeDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
		 prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	public SecurityConfiguration() {
        super();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { // @formatter:off 
        auth.userDetailsService(employeeDetailsService);
        
    } 
	
   @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http
        .authorizeRequests()
        //.antMatchers("/login", "/register").permitAll()
        .anyRequest().authenticated()
        
        .and()
        .formLogin().
            loginPage("/login").permitAll().
            loginProcessingUrl("/doLogin")
        .successHandler(authenticationSuccessHandler)
        .and()
        .logout().permitAll().logoutUrl("/logout")
        .and()
        .csrf().disable()
        ;
    }
   
    
   
   @SuppressWarnings("deprecation")
   @Bean
   public static NoOpPasswordEncoder passwordEncoder() {
   return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
   }
	
	
	
	
	
}
