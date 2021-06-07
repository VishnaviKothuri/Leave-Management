package com.project.leaveapplication.security;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.model.Role;
public class EmployeeDetails implements UserDetails{
/**
	 * 
	 */
private static final long serialVersionUID = 3524020486778900125L;
private Employee employee;

private String firstname;

	public EmployeeDetails(Employee employee) {
	super();
	this.employee = employee;
}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return  getAuthorities(employee.getRoles());
	}

	

	
	@Override
	public String getPassword() {
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		
		return employee.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
    	
	public Long getId() {
		return employee.getEmployeeId();
	}
	
	public String getFirstName() {
		return employee.getFirstName();
	}
    

private Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
		
		return roles.stream().flatMap(role -> role.getPrivileges().stream()).map(p->new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
	}




}
