package com.project.leaveapplication.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leaveapplication.model.Employee;
import com.project.leaveapplication.model.Role;
@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {
	
 
	
}
