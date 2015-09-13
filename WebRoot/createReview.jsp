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

<title>create Review</title>

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
	<h2>Create Review</h2>
	<s:form>
		<s:if test='%{review == null || review.initiator == null || review.initiator == #session.user.username}'>
				<s:textfield name="reviewYear" label="review year" value="%{review.reviewYear}" readonly="false"/>
				<s:radio label="Self Rate" name="selfRate" list="#{'1':'exceptional','2':'exceeds expectation','3':'achieve expectation','4':'meet some expectation','5':'does not meet'}" value="%{review.selfRate}" />
				<s:textarea name="selfAssessment" label="Self Assessment" value="%{review.selfAssessment}" cols="50" rows="5" readonly="false"/>
			</s:if>
			<s:else>
				<s:textfield name="reviewYear" label="review year" value="%{review.reviewYear}" readonly="true"/>
				<s:label label="Self Rate" name="selfRate" value="%{review.selfRate}"/>
				<s:textarea name="selfAssessment" label="Self Assessment" value="%{review.selfAssessment}" cols="50" rows="5" readonly="true"/>
			</s:else>
			<s:label value='%{review.initiator}'/>
			<s:label value='%{#session.user.username}'/>
			<s:label value='%{review.supervisorReviewer}'/>
			<s:if test='%{review.status == "supervisor" && #session.user.username == review.supervisorReviewer}'>
				<s:textarea name="supervisorAssessment" label="Supervisor Assessment" value="%{review.supervisorAssessment}" cols="50" rows="5" readonly="false"/>
			</s:if>
			<s:elseif test='%{review.status == "supervisor" || review.status == "HR"}'>
				<s:textarea name="supervisorAssessment" label="Supervisor Assessment" value="%{review.supervisorAssessment}" cols="50" rows="5" readonly="true"/>
			</s:elseif>
			
			<s:label value='%{review.status}'></s:label>
			<s:label value='%{#session.user.dept}'></s:label>
			<s:if test='%{review.status == "HR" && #session.user.dept == "HR-department"}'>
				<s:textarea name="hrAssessment" label="HR Asseessment" value="%{review.hrAssessment}" cols="50" rows="5" readonly="false"/>
			</s:if>
			<s:elseif test='%{review.status == "HR"'>
				<s:textarea name="hrAssessment" label="HR Asseessment" value="%{review.hrAssessment}" cols="50" rows="5" readonly="true"/>
			</s:elseif>
			
			<s:if test='%{review == null}'>
				<s:submit value="submit" name="submit" onclick="form.action='submitReview';"/>
				<s:submit value="save" name="save" onclick="form.action='createReview';"/>
			</s:if>
			<s:if test='%{review.status == "initiator" && review.initiator == #session.user.username}'>
				<s:submit value="submit" name="submit" onclick="form.action='submitReview';"/>
				<s:submit value="save" name="save" onclick="form.action='createReview';"/>
			</s:if>
			<s:if test='%{review.status == "supervisor" && review.supervisorReviewer == #session.user.username}'>
				<s:submit value="submit" name="submit" onclick="form.action='submitReview';"/>
				<s:submit value="save" name="save" onclick="form.action='createReview';"/>
			</s:if>	
			<s:if test='%{review.status == "HR" && #session.user.dept == "HR-department"}'>
				<s:submit value="submit" name="submit" onclick="form.action='submitReview';"/>
				<s:submit value="save" name="save" onclick="form.action='createReview';"/>
			</s:if>
	</s:form>
</body>
</html>
