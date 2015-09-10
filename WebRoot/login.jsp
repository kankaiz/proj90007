<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>login</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
		<s:fielderror></s:fielderror>

		<s:form action="login" method="post">
		
<!-- 			UserName<input type="text" name="name" id="name" /><br /> 
			Password<input type="password" name="password" id="password" /><br /> 
			<input type="submit" value="login" /> -->
			
		<s:textfield name="name" label="username"></s:textfield>
		<s:password name="password" label="password"></s:password>
		<s:submit label="submit" value="login"></s:submit>
		
		</s:form>


</body>
</html>
