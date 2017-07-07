package com.proj90007.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer deptId;
	private String deptName;
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** minimal constructor */
	public Dept(String deptName) {
		this.deptName = deptName;
	}

	/** full constructor */
	public Dept(String deptName, Set<User> users) {
		this.deptName = deptName;
		this.users = users;
	}

	// Property accessors
	
	public Boolean isHrDept() {
		if (this.deptName.equals("HR-department")) // hard code here
			return true;
		else return false;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}