package com.proj90007.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Dept dept;
	private User user;
	private String username;
	private String password;
	private String status;
	private Set users = new HashSet(0);
	private Set profiles = new HashSet(0);
	private Set reviewsForReviewedHrId = new HashSet(0);
	private Set reviewsForInitiatorId = new HashSet(0);
	private Set reviewsForReviewedSupervisorId = new HashSet(0);

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
	public User(Integer id, Dept dept, User user, String username,
			String password, String status, Set users, Set profiles,
			Set reviewsForReviewedHrId, Set reviewsForInitiatorId,
			Set reviewsForReviewedSupervisorId) {
		this.id = id;
		this.dept = dept;
		this.user = user;
		this.username = username;
		this.password = password;
		this.status = status;
		this.users = users;
		this.profiles = profiles;
		this.reviewsForReviewedHrId = reviewsForReviewedHrId;
		this.reviewsForInitiatorId = reviewsForInitiatorId;
		this.reviewsForReviewedSupervisorId = reviewsForReviewedSupervisorId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getProfiles() {
		return this.profiles;
	}

	public void setProfiles(Set profiles) {
		this.profiles = profiles;
	}

	public Set getReviewsForReviewedHrId() {
		return this.reviewsForReviewedHrId;
	}

	public void setReviewsForReviewedHrId(Set reviewsForReviewedHrId) {
		this.reviewsForReviewedHrId = reviewsForReviewedHrId;
	}

	public Set getReviewsForInitiatorId() {
		return this.reviewsForInitiatorId;
	}

	public void setReviewsForInitiatorId(Set reviewsForInitiatorId) {
		this.reviewsForInitiatorId = reviewsForInitiatorId;
	}

	public Set getReviewsForReviewedSupervisorId() {
		return this.reviewsForReviewedSupervisorId;
	}

	public void setReviewsForReviewedSupervisorId(
			Set reviewsForReviewedSupervisorId) {
		this.reviewsForReviewedSupervisorId = reviewsForReviewedSupervisorId;
	}

}