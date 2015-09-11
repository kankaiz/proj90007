package com.proj90007.service;

import java.util.Set;

import com.proj90007.model.Review;
import com.proj90007.model.User;

public interface UserService {

	public boolean login(String name,String password);
	
	public Set<Review> listSelfReviews(User user);
	
}
