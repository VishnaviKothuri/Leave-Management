package com.project.leaveapplication.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class LeaveRecords{
@Id
@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
private Long id;

private Date fromDate;

private Date toDate;

private Integer noOfDays;

@OneToOne
private LeaveType leaveType;

private String quarter;

private String reason;


private Integer acceptReject;


private Integer status;

@ManyToOne
private Employee employee;

public LeaveRecords() {
	super();
}


public LeaveRecords(Date fromDate, Date toDate, Integer noOfDays,  String quarter,
		String reason,Integer acceptReject, Integer status) {
	super();
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.noOfDays = noOfDays;
	this.quarter = quarter;
	this.reason = reason;
	this.acceptReject=acceptReject;
	this.status = status;
	
}


public LeaveRecords(Date fromDate, Date toDate, Integer noOfDays, String quarter, String reason) {
	this.fromDate=fromDate;
	this.toDate=toDate;
	this.noOfDays=noOfDays;
	this.quarter=quarter;
	this.reason=reason;
}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
public Date getFromDate() {
	return fromDate;
}

public void setFromDate(Date fromDate) {
	this.fromDate = fromDate;
}

public Date getTodate() {
	return toDate;
}

public void setTodate(Date todate) {
	this.toDate = todate;
}

public Integer getNoOfDays() {
	return noOfDays;
}

public void setNoOfDays(Integer noOfDays) {
	this.noOfDays = noOfDays;
}

public LeaveType getLeaveType() {
	return leaveType;
}



public void setLeaveType(LeaveType leaveType) {
	this.leaveType = leaveType;
}

public String getQuarter() {
	return quarter;
}

public void setQuarter(String quarter) {
	this.quarter = quarter;
}

public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}


public Integer isAcceptReject() {
	return acceptReject;
}


public void setAcceptReject(Integer acceptReject) {
	this.acceptReject = acceptReject;
}


public Integer isStatus() {
	return status;
}

public void setStatus(Integer status) {
	this.status = status;
}


public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}



@Override
public String toString() {
	return "LeaveRecords [id=" + id + ", fromDate=" + fromDate + ", todate=" + toDate + ", noOfDays=" + noOfDays
			+ ", leaveType=" + leaveType + ", Quarter=" + quarter + ", reason=" + reason + ", status=" + status + "]";
}

}
