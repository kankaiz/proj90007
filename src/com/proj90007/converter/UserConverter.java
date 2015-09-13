package com.proj90007.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.proj90007.model.User;

public class UserConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map map, String[] values, Class toClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String convertToString(Map map, Object o) {
		User user = (User)o;
		
		return user.getUsername();
	}

}
