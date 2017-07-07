package com.proj90007.service;

import com.proj90007.dao.ReviewDAO;
import com.proj90007.model.Review;

public class ReviewServiceImpl implements ReviewService {
	
	private ReviewDAO reviewDAO;
	

	public ReviewDAO getReviewDAO() {
		return reviewDAO;
	}

	public void setReviewDAO(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}


	@Override
	public void createReview(Review review ) {
		reviewDAO.save(review);
	}
	
	
	@Override
	public void editReview(Review review) {
		reviewDAO.attachDirty(review);
	}

	@Override
	public void deleteReview(Integer reviewID) {
		//Review review = new Review();
		//review.setId(reviewID);
		Review review =reviewDAO.findById(reviewID);
		reviewDAO.delete(review);
	}
	
	@Override
	public Review getReviewByID(Integer reviewID) {
		Review review = reviewDAO.findById(reviewID);
		return review;
	}
}
