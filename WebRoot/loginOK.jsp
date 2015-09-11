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

<title>loginOK</title>

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
	<center>
		<h1>Login Is Ok</h1>
	</center>
	<s:form>
		<%--     	Hello: ${requestScope.name} <br>
		 <%session.getAttribute("user").toString(); %><br>
    	again <%=request.getParameter("name")%> --%>
    	Hello:<s:property value="#session.user.username" />
	</s:form>

	<s:if test="selfReviews.size() > 0">
		<table border="1px" cellpadding="8px">
			<tr>
				<th>ReviewYear</th>
				<th>SelfRate</th>
				<th>SelfAssessment</th>
				<th>Delete</th>
			</tr>
			<s:iterator value="selfReviews">
				<tr>
					<td><s:property value="reviewYear" /></td>
					<td><s:property value="selfRate" /></td>
					<td><s:property value="selfAssessment" /></td>
					<td><a href="${pageContext.request.contextPath }/deleteReview.action?id=<s:property value="id"/>">delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

	<a href="<s:url value="createReview.jsp"  />">Create Review</a>


</body>
</html>
