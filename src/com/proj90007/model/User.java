package com.proj90007.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Dept dept;
	private User supervisor;
	private String username;
	private String password;
	private String status;
	private Set<User> subordinates = new HashSet<User>(0);
	//private Set profiles = new HashSet(0);
	private Profile profile;
	private Set<Review> reviewsAsHR = new HashSet<Review>(0);
	@OneToMany(fetch=FetchType.LAZY)
	private Set<Review> selfReviews = new HashSet<Review>(0);
	private Set<Review> reviewsAsSupervisor = new HashSet<Review>(0);
	private Set<Review> reviewsToBeArchived = new HashSet<Review>(0);

	// Constructors
	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id, String username) {
		this.id = id;
		this.username = username;
	}

	/** full constructor */
	public User(Integer id, Dept dept, User supervisor, String username,
			String password, String status, Set<User> subordinates, Profile profile,
			Set<Review> reviewsAsHR, Set<Review> selfReviews,
			Set<Review> reviewsAsSupervisor, Set<Review> reviewsToBeArchived) {
		this.id = id;
		this.dept = dept;
		this.supervisor = supervisor;
		this.username = username;
		this.password = password;
		this.status = status;
		this.subordinates = subordinates;
		this.profile = profile;
		this.reviewsAsHR = reviewsAsHR;
		this.selfReviews = selfReviews;
		this.reviewsAsSupervisor = reviewsAsSupervisor;
		this.reviewsToBeArchived = reviewsToBeArchived;
	}

	// Property accessors
	
	public Boolean isHR() {
		Hibernate.initialize(this.dept);
		return this.dept.isHrDept();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@TypeConversion(converter = "com.proj90007.converter.DeptConverter")
	public Dept getDept() {
		return this.dept;
	}
	
	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public User getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(User supervisor) {
		this.supervisor = supervisor;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<User> getSubordinates() {
		return this.subordinates;
	}

	public void setSubordinates(Set<User> subordinates) {
		this.subordinates = subordinates;
	}

//	public Set getProfiles() {
//		return this.profiles;
//	}
//
//	public void setProfiles(Set profiles) {
//		this.profiles = profiles;
//	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Review> getReviewsAsHR() {
		return this.reviewsAsHR;
	}

	public void setReviewsAsHR(Set<Review> reviewsAsHR) {
		this.reviewsAsHR = reviewsAsHR;
	}

	public Set<Review> getSelfReviews() {
		return this.selfReviews;
	}

	public void setSelfReviews(Set<Review> selfReviews) {
		this.selfReviews = selfReviews;
	}

	public Set<Review> getReviewsAsSupervisor() {
		return this.reviewsAsSupervisor;
	}

	public void setReviewsAsSupervisor(
			Set<Review> reviewsAsSupervisor) {
		this.reviewsAsSupervisor = reviewsAsSupervisor;
	}
	
	public Set<Review> getReviewsToBeArchived() {
		return reviewsToBeArchived;
	}

	public void setReviewsToBeArchived(Set<Review> reviewsToBeArchived) {
		this.reviewsToBeArchived = reviewsToBeArchived;
	}


}