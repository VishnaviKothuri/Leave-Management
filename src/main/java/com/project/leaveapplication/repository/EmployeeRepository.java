package com.project.leaveapplication.repository;


import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.leaveapplication.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	
	
	}
