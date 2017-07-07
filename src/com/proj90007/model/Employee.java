package com.proj90007.model;

import java.util.HashSet;
import java.util.Set;

public class Employee extends User {
	
	private Integer id;
	private Dept dept;
	private User supervisor;
	private String username;
	private String password;
	private String status;
	private Set<User> subordinates = new HashSet<User>(0);
	//private Set profiles = new HashSet(0);
	private Profile profile;
	private Set<Review> selfReviews = new HashSet<Review>(0);
	private Set<Review> reviewsAsSupervisor = new HashSet<Review>(0);
	
	/** full constructor */
	public Employee(Integer id, Dept dept, User supervisor, String username,
			String password, String status, Set<User> subordinates, Profile profile,
			Set<Review> selfReviews,Set<Review> reviewsAsSupervisor) {
		this.id = id;
		this.dept = dept;
		this.supervisor = supervisor;
		this.username = username;
		this.password = password;
		this.status = status;
		this.subordinates = subordinates;
		this.profile = profile;
		this.selfReviews = selfReviews;
		this.reviewsAsSupervisor = reviewsAsSupervisor;
	}

	@Override
	public Boolean isHR() {
		return false;
	}

}
