package com.project.leaveapplication.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.leaveapplication.model.LeaveType;

@Repository
@Transactional
public interface LeaveTypeRepository extends JpaRepository<LeaveType,Long>{

	public Optional<LeaveType> findById(Long leaveTypeId) ;
	
	
}
