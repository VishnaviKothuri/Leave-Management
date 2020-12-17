package com.project.leaveapplication.model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import javax.persistence.JoinColumn;
@Entity

public class Role {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	private Long id;
	
	
	@ManyToMany(mappedBy="role")
	
	private Set<Employee> employee = new HashSet<>();
	@ManyToMany
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
	private Set<Privilege> privileges = new HashSet<>();
	
	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}


	public Role() {
		super();
	}


	public Long getId() {
		return id;
	}

	
	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void addPrivilege(Privilege privilege) {
		this.privileges.add(privilege);
	}
	
	public void removePrivilege(Privilege privilege) {
		this.privileges.remove(privilege);
	}
	

	public void addEmployee(Employee employee) {
		this.employee.add(employee);
	}
	
	public void removeEmployee(Employee employee) {
		this.employee.remove(employee);
	}
	
	public Collection<Employee> getEmployee() {
		return employee;
	}


	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=")
            .append(name)
            .append("]")
            .append("[id=")
            .append(id)
            .append("]");
        return builder.toString();
    }
	
	
	
}
