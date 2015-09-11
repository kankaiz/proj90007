package com.proj90007.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionContext;
import com.proj90007.dao.UserDAO;
import com.proj90007.model.Review;
import com.proj90007.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean login(String name, String password) {
		List u = userDAO.findByUsername(name);
		if (u.isEmpty()) {
			return false;
		} else {
			User user = (User) u.get(0);
			if (user.getPassword().equals(password)) {
				ActionContext.getContext().getSession().put("user",user );
				if(user!=null){  
					Hibernate.initialize(user.getSelfReviews());  
		        } 
				return true;
			} else {
				return false;
			}
		}
	}
	
	@Override
	public Set<Review> listSelfReviews(User user) {
		User u = userDAO.findById(user.getId());
		Hibernate.initialize(u.getSelfReviews());  
		Set<Review> selfReviews = u.getSelfReviews();
		return selfReviews;
	}

}
