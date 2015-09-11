package com.proj90007.action;

import java.util.Set;

import org.apache.struts2.ServletActionContext;

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
	
	private ReviewService reviewService;
	
	private UserService userService;
	
	//private List<Review> selfReviews;
	private Set<Review> selfReviews;
	
	
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
		review.setReviewYear(reviewYear);
		review.setSelfRate(selfRate);
		review.setSelfAssessment(selfAssessment);
		review.setUserByInitiatorId(user);
		review.setStatus("initiate");
		
		reviewService.createReview(review);
		
		//selfReviews = reviewService.listSelfReviews(user);
		//System.out.println(selfReviews.toString());
		return SUCCESS;
	}
	
	public String listReviews() {
		User user = (User) ServletActionContext.getContext().getSession().get("user");
		selfReviews = userService.listSelfReviews(user);
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

	public void setSelfReviews(Set<Review> selfReviews) {
		this.selfReviews = selfReviews;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
