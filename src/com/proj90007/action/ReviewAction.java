package com.proj90007.action;

import java.sql.Date;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionSupport;
import com.proj90007.model.Review;
import com.proj90007.model.User;
import com.proj90007.service.ReviewService;
import com.proj90007.service.UserService;


public class ReviewAction extends ActionSupport {
	
	private Review review;
	private String searchedUsernamae;
	private int id;	
	private int reviewYear;
	private int selfRate;
	private String selfAssessment;
	private String supervisorAssessment;
	private String hrAssessment;
	private ReviewService reviewService;
	private UserService userService;

	//private List<Review> selfReviews;
	private Set<Review> selfReviews;
	private Set<Review> subordinateReviews;
	private Set<Review> allEmployeeReviews;
	private Set<Review> searchedReviews;
	
	//Status Strings
	private final static String STATUS_INITIATE = "initiate";
	private final static String STATUS_SUPORVISOR = "supervisor";
	private final static String STATUS_HR = "HR";

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		super.validate();
	}
	
	
	public String createReview() {
		User user = (User) ServletActionContext.getContext().getSession().get("user");
			review = new Review();
			review.setReviewYear(reviewYear);
			review.setSelfRate(selfRate);
			review.setSelfAssessment(selfAssessment);
			review.setInitiator(user);
			review.setStatus(STATUS_INITIATE);		
		
		reviewService.createReview(review);
		return SUCCESS;
	}
	
	public String listReviews() {
		User user = (User) ServletActionContext.getContext().getSession().get("user");
		selfReviews = userService.listSelfReviews(user);
		
		// if user is a supervisor
		subordinateReviews = userService.listSubordinateReviews(user);
		
		// if user is an hr
		allEmployeeReviews = userService.listReviewsToBeArchived(user);

		return SUCCESS;
	}
	
	public String searchReviews() {
		searchedReviews = userService.getReviewsByUsername(searchedUsernamae);
		return SUCCESS;
	}
	
	public String deleteReview() {
		reviewService.deleteReview(this.id);
		return SUCCESS;
	}
	
	public String attempEditReview() {
		review = reviewService.getReviewByID(this.id);
		return SUCCESS;
	}
	
	public String editReview() {
		User user = (User) ServletActionContext.getContext().getSession().get("user");
		if(review.getStatus().equals(STATUS_INITIATE)) {
			review.setReviewYear(reviewYear);
			review.setSelfRate(selfRate);
			review.setSelfAssessment(selfAssessment);
		}
		if(review.getStatus().equals(STATUS_SUPORVISOR)){
			review.setReviewYear(reviewYear);
			review.setSelfRate(selfRate);
			review.setSelfAssessment(selfAssessment);
			review.setSupervisorAssessment(supervisorAssessment);
		}
		if(review.getStatus().equals(STATUS_HR) && user.isHR()) {
			review.setHrAssessment(hrAssessment);
		}
		reviewService.editReview(review);
		return SUCCESS;
	}
	
	public String submitReview() {
		User user = (User) ServletActionContext.getContext().getSession().get("user");
		if (review == null) {
			review = new Review();
			review.setInitiator(user);
			review.setStatus(STATUS_INITIATE);
		}
		
		if (review.getStatus().equals(STATUS_INITIATE)) {
			review.setReviewYear(reviewYear);
			review.setSelfRate(selfRate);
			review.setSelfAssessment(selfAssessment);
			review.setSupervisorReviewer(user.getSupervisor());
			review.setStatus(STATUS_SUPORVISOR);
		}
		else if (review.getStatus().equals(STATUS_SUPORVISOR)) {
			review.setStatus(STATUS_HR);
			review.setReviewYear(reviewYear);
			review.setSelfRate(selfRate);
			review.setSelfAssessment(selfAssessment);
			review.setSupervisorAssessment(supervisorAssessment);
		}
		else if(review.getStatus().equals(STATUS_HR)) {
			if(user.isHR()) {
				review.setHrReviewer(user);
				review.setHrAssessment(hrAssessment);
			}
		}
		reviewService.editReview(review);

		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public int getReviewYear() {
		return reviewYear;
	}

	public void setReviewYear(int reviewYear) {
		this.reviewYear = reviewYear;
	}

	public int getSelfRate() {
		return selfRate;
	}

	public void setSelfRate(int selfRate) {
		this.selfRate = selfRate;
	}
	
	public String getSupervisorAssessment() {
		return supervisorAssessment;
	}

	public void setSupervisorAssessment(String supervisorAssessment) {
		this.supervisorAssessment = supervisorAssessment;
	}

	public String getHrAssessment() {
		return hrAssessment;
	}

	public void setHrAssessment(String hrAssessment) {
		this.hrAssessment = hrAssessment;
	}

	public String getSelfAssessment() {
		return selfAssessment;
	}

	public void setSelfAssessment(String selfAssessment) {
		this.selfAssessment = selfAssessment;
	}

	public ReviewService getReviewService() {
		return reviewService;
	}

	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	public Set<Review> getSelfReviews() {
		return selfReviews;
	}
	
	public Set<Review> getSubordinateReviews() {
		return subordinateReviews;
	}

	public void setSubordinateReviews(Set<Review> subordinateReviews) {
		this.subordinateReviews = subordinateReviews;
	}

	public void setSelfReviews(Set<Review> selfReviews) {
		this.selfReviews = selfReviews;
	}
	
	public Set<Review> getAllEmployeeReviews() {
		return allEmployeeReviews;
	}

	public void setAllEmployeeReviews(Set<Review> allEmployeeReviews) {
		this.allEmployeeReviews = allEmployeeReviews;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Set<Review> getSearchedReviews() {
		return searchedReviews;
	}

	public void setSearchedReviews(Set<Review> searchedReviews) {
		this.searchedReviews = searchedReviews;
	}

	public String getSearchedUsernamae() {
		return searchedUsernamae;
	}

	public void setSearchedUsernamae(String searchedUsernamae) {
		this.searchedUsernamae = searchedUsernamae;
	}
	

}
