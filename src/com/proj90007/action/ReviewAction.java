package com.proj90007.action;

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
	
//	HttpServletRequest request = ServletActionContext.getRequest();
//	String name = request.getParameter("name");

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
		if(review == null) {
			review = new Review();
			review.setInitiator(user);
			review.setStatus("initiate");
		}
		if(review.getStatus() == "initiate") {
			review.setReviewYear(reviewYear);
			review.setSelfRate(selfRate);
			review.setSelfAssessment(selfAssessment);
		}
		if(review.getStatus() == "supervisor" && user.isSupervisor()){
			review.setSupervisorAssessment(supervisorAssessment);
		}
		if(review.getStatus() == "HR" && user.isHR()) {
			review.setHrAssessment(hrAssessment);
		}
		
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
	
	public String deleteReview() {
		reviewService.deleteReview(this.id);
		return SUCCESS;
	}
	
	public String attempEditReview() {
		review = reviewService.getReviewByID(this.id);
		return SUCCESS;
	}
	
	public String editReview() {
		review.setReviewYear(reviewYear);
		review.setSelfRate(selfRate);
		review.setSelfAssessment(selfAssessment);
		reviewService.createReview(review);
		return SUCCESS;
	}
	
	public String submitReview() {
		User user = (User) ServletActionContext.getContext().getSession().get("user");
		if (review == null) {
			review = new Review();
			review.setInitiator(user);
			review.setStatus("initiate");
		}
		
		if (review.getStatus().equals("initiate")) {
			review.setReviewYear(reviewYear);
			review.setSelfRate(selfRate);
			review.setSelfAssessment(selfAssessment);
			review.setSupervisorReviewer(user.getSupervisor());
			review.setStatus("supervisor");
		}
		else if (review.getStatus().equals("supervisor")) {
			if(userService.isSupervisor(user)) {
				review.setStatus("HR");
			}
			//TODO supervisor gives comments
		}
		else if(review.getStatus().equals("HR")) {
			//TODO HR gives comments
			if(userService.isHR(user)) {
				review.setHrReviewer(user);
			}
		}
		reviewService.createReview(review);

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
	
	

}
