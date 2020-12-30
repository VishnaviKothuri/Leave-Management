package com.project.leaveapplication.model;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity

public class Employee {

@Id
@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )

private Long id;


private String firstName;

private String lastName;

private String email;

private String password;


private Date dateOfJoining;

private String contactNumber;

private String gender;

private Integer status;

@ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
@JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
private Set<Role> role = new HashSet<>();

@OneToMany(mappedBy = "employee")
private Set<LeaveRecords> applyLeave = new HashSet<>();

public Employee() {
	super();
}


public Employee(String firstName, String lastName, String email, String password, Date dateOfJoining,
		String contactNumber, String gender) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.dateOfJoining = dateOfJoining;
	this.contactNumber = contactNumber;
	this.gender = gender;
	
}


public Long getEmployeeId() {
	return id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Date getDateOfJoining() {
	return dateOfJoining;
}

public void setDateOfJoining(Date dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
}

public String getContactNumber() {
	return contactNumber;
}

public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}


public Integer getStatus() {
	return status;
}


public void setStatus(Integer status) {
	this.status = status;
}


public Collection<Role> getRoles() {
	return role;
}

public void addRole(Role role) {
	this.role.add(role);
}


public void removeRole(Role role) {
	this.role.remove(role);
}

public Set<LeaveRecords> getApplyLeave() {
	return applyLeave;
}

public void addLeave(LeaveRecords leave) {
	this.applyLeave.add(leave);
}

public void removeLeave(LeaveRecords leave) {
	this.applyLeave.remove(leave);
}



public Set<Role> getRole() {
	return role;
}


public void setRole(Set<Role> role) {
	this.role = role;
}


public void setApplyLeave(Set<LeaveRecords> applyLeave) {
	this.applyLeave = applyLeave;
}


@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", password=" + password + ", dateOfJoining=" + dateOfJoining + ", contactNumber=" + contactNumber
			+ ", gender=" + gender + ", role=" + role + ", applyLeave=" + applyLeave + "]";
}






}
