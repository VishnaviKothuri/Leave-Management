package com.project.leaveapplication.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leaveapplication.model.LeaveRecords;

@Repository
@Transactional
public interface LeaveRepository extends JpaRepository<LeaveRecords,Long> {

}
