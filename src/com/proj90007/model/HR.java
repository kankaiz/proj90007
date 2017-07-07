package com.proj90007.model;

import java.util.HashSet;
import java.util.Set;

public class HR extends User {
	
	private Set<Review> reviewsAsHR = new HashSet<Review>(0);

	public Boolean isHR(){
		return true;
	}
	
	public Set<Review> getReviewsAsHR() {
		return this.reviewsAsHR;
	}

	public void setReviewsAsHR(Set<Review> reviewsAsHR) {
		this.reviewsAsHR = reviewsAsHR;
	}

}
