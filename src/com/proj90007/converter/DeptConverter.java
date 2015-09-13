package com.proj90007.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.proj90007.model.Dept;


public class DeptConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map map, String[] values, Class toClass) {
		Dept dept = new Dept();
		
		return dept;
	}

	@Override
	public String convertToString(Map map, Object o) {
		Dept dept = (Dept) o;
		String deptName = "deptName = " + dept.getDeptName();
		return "dept = HR_department";
	}

}
