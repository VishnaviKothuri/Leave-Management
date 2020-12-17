package com.project.leaveapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class LeaveType {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	private Long id;
	
	private String type;
	
	private Integer noOfLeaves;

	public LeaveType() {
		super();
	}

	public LeaveType( String type, Integer noOfLeaves) {
		super();
		
		this.type = type;
		this.noOfLeaves = noOfLeaves;
	}

	public Long getId() {
		return id;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(Integer noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}

	@Override
	public String toString() {
		return "LeaveType [id=" + id + ", type=" + type + ", noOfLeaves=" + noOfLeaves + "]";
	}
	
	
		
}
