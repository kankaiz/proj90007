package com.proj90007.service;

import java.util.ArrayList;

import com.proj90007.model.Review;

public interface ReviewService {
	
	public void createReview(Review review);
	
	public void editReview(Review review);
	
	public void deleteReview(Integer reviewID);
	
	public Review getReviewByID(Integer reviewID);

}
