package com.proj90007.action;

import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.proj90007.model.User;
import com.proj90007.service.UserService;

public class LoginAction extends ActionSupport {
	private String name;
	private String password;
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
		
	@Override
	public String execute() throws Exception {
		Boolean loginSuccess = userService.login(name, password);
		if (loginSuccess) {
			return SUCCESS;
		} else {
			this.addFieldError("password", "invalid password");
			return ERROR;
		}
	}

	@Override
	public void validate() {
		if (null == this.getName().trim() || "".equals(this.getName().trim())) {
			this.addFieldError("name", "enter username");
		}
		if (null == this.getPassword().trim() || "".equals(this.getPassword().trim())) {
			this.addFieldError("password", "enter password");
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
