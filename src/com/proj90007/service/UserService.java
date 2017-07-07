package com.proj90007.service;

import java.util.ArrayList;
import java.util.Set;

import com.proj90007.model.Review;
import com.proj90007.model.User;

public interface UserService {

	public boolean login(String name,String password);
	
	public Set<Review> listSelfReviews(User user);
	
	public Set<Review> listSubordinateReviews(User supervsor);
	
	public Set<Review> listReviewsAsHr(User hr);
	
	public Set<Review> listReviewsToBeArchived(User hr);
	
	// Feature B Search - 2015.10.10
	public Set<Review> getReviewsByUsername(String Username);
	
}
