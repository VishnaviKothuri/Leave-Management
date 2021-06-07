package com.project.leaveapplication.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.repository.EmployeeRepository;
@Service
public class EmployeeDetailsService implements UserDetailsService {
@Autowired
EmployeeRepository employeeRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Employee employee = employeeRepository.findByEmail(email);
		
		
		if(employee == null) {
			throw new UsernameNotFoundException("No user with email :"+email);
		}
		return new EmployeeDetails(employee);

	//return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(), true, true, true, true, getAuthorities(employee.getRoles()));
	}
	
	//private Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
		
		//return roles.stream().flatMap(role -> role.getPrivileges().stream()).map(p->new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
	//}

}
