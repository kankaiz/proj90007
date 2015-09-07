package com.proj90007.service;

import com.proj90007.dao.UserDAO;
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
		
		User u = userDAO.findByUsername(name);
		if (u == null) {
			return false;
		} else {
			if (u.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		}

	}

}
