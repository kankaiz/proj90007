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
		<h1>LoginOk</h1>
	</center>
	<s:form>
		<%--     	Hello: ${requestScope.name} <br>
		 <%session.getAttribute("user").toString(); %><br>
    	again <%=request.getParameter("name")%> --%>
    	Hello:<s:property value="#session.user.username" />
	</s:form>
	
	<s:if test="selfReviews.size() > 0">
	<h1>Self Review</h1>
		<table border="1px" cellpadding="8px">
			<tr>
				<th>Status</th>
				<th>ReviewYear</th>
				<th>SelfRate</th>
				<th>SelfAssessment</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<s:iterator value="selfReviews" id="review">
				<tr>
					<td><s:property value="#review.status" /></td>
					<td><s:property value="#review.reviewYear" /></td>
					<td><s:property value="#review.selfRate" /></td>
					<td><s:property value="#review.selfAssessment" /></td>
					<td><a href="${pageContext.request.contextPath }/attempEditReview.action?id=<s:property value="id"/>">edit</a></td>
					<td><a href="${pageContext.request.contextPath }/deleteReview.action?id=<s:property value="id"/>">delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

	<a href="<s:url value="createReview.jsp"  />">Create Review</a>

	<s:if test="subordinateReviews.size() > 0">
	<h1>Subordinates' Review</h1>
		<table border="1px" cellpadding="8px">
			<tr>
				<th>Subordinate</th>
				<th>Status</th>
				<th>ReviewYear</th>
				<th>SelfRate</th>
				<th>SelfAssessment</th>
				<th>Edit</th>
			</tr>
			<s:iterator value="subordinateReviews" id="review">
				<tr>
					<td><s:property value="#review.initiator"/></td>
					<td><s:property value="#review.status" /></td>
					<td><s:property value="#review.reviewYear" /></td>
					<td><s:property value="#review.selfRate" /></td>
					<td><s:property value="#review.selfAssessment" /></td>
					<td><a href="${pageContext.request.contextPath }/attempEditReview.action?id=<s:property value="id"/>">edit</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
	
	<s:if test='%{allEmployeeReviews.size() > 0 || #session.user.dept.deptName == "HR-department"}'>
	<s:label value='%{#session.user.dept}'/>
	<h1>All Employees' Review</h1>
		<table border="1px" cellpadding="8px">
			<tr>
				<th>Initiator</th>
				<th>Status</th>
				<th>ReviewYear</th>
				<th>SelfRate</th>
				<th>SelfAssessment</th>
				<th>Edit</th>
			</tr>
			<s:iterator value="allEmployeeReviews" id="review">
				<tr>
					<td><s:property value="#review.initiator"/></td>
					<td><s:property value="#review.status" /></td>
					<td><s:property value="#review.reviewYear" /></td>
					<td><s:property value="#review.selfRate" /></td>
					<td><s:property value="#review.selfAssessment" /></td>
					<td><a href="${pageContext.request.contextPath }/attempEditReview.action?id=<s:property value="id"/>">edit</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

</body>
</html>
