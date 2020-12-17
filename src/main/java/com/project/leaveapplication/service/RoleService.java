package com.project.leaveapplication.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leaveapplication.model.Role;
import com.project.leaveapplication.repository.RoleRepository;


@Service
public class RoleService {
@Autowired
RoleRepository roleRepository;

public  Role fidRoleById(Long roleId) {
	return null;
	


}

public List<Role> findAllRoles() {
	
	return roleRepository.findAll();
}
}
