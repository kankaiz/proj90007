package com.proj90007.action;

import com.proj90007.service.UserService;

public class LoginAction {
	private String name;
	private String password;
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		if (null == name && null == password) {
			return "login";
		} else {
			Boolean u = userService.login(name, password);
			if (u) {
				return "ok";
			} else {
				return "error";
			}

		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
