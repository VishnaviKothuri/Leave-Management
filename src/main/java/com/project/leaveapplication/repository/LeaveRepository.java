package com.project.leaveapplication.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.leaveapplication.model.LeaveRecords;

@Repository
@Transactional
public interface LeaveRepository extends JpaRepository<LeaveRecords,Long> {



@Query(value = "select count(leave_type_id) from leave_records  where employee_id=:employeeId and leave_type_id=:leaveTypeId and quarter=:qua",nativeQuery=true)
public int getLeavesUsedByEmployee(@Param("leaveTypeId") Long typeId, @Param("employeeId") Long employeeId,@Param("qua") String quarterMonth);

@Query(value ="select count(*) from leave_records where employee_id=:employeeId and quarter=:qua and leave_type_id=1000",nativeQuery=true)
public int getEarnedLeavesById(@Param("employeeId") Long employeeId,@Param("qua") String quarterMonth);

@Query(value ="select count(*) from leave_records where employee_id=:employeeId and quarter=:qua and leave_type_id=1001",nativeQuery=true)
public int getsickLeavesById(@Param("employeeId") Long employeeId,@Param("qua") String quarterMonth);

@Query(value="select * from leave_records where employee_id=:employeeId",nativeQuery=true)
public List<LeaveRecords> findEmployeeLeaveHistory(@Param("employeeId")Long employeeId);

}

