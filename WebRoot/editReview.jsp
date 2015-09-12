<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>My JSP 'editReview.jsp' starting page</title>

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
	<h2>Edit Review</h2>
	<s:form>
		<s:textfield name="reviewYear" label="review year" value="%{review.reviewYear}"/>
		<s:radio label="Self Rate" name="selfRate"
			list="#{'1':'exceptional','2':'exceeds expectation','3':'achieve expectation','4':'meet some expectation','5':'does not meet'}"
			value="%{review.selfRate}" />
		<s:textarea name="selfAssessment" label="Self Assessment" value="%{review.selfAssessment}" cols="50"
			rows="5" />
		<s:submit value="submit" name="submit" onclick="form.action='submitReview';"/>
		<s:submit value="save" name="save" onclick="form.action='editReview';"/>
	</s:form>
</body>
</html>
