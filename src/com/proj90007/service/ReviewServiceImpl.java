package com.proj90007.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.proj90007.dao.ReviewDAO;
import com.proj90007.dao.UserDAO;
import com.proj90007.model.Review;
import com.proj90007.model.User;

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
		reviewDAO.attachDirty(review);
	}
	
	
}
