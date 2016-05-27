<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/classes/templates/core/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试系统-<sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body>
	<div>
		<a href="${ctx}">主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<%
			Subject currentUser = SecurityUtils.getSubject();
			if ((null != currentUser) && (currentUser.isAuthenticated())) {

				out.print(currentUser.getPrincipal().toString() + " <a href=\"/javaweb/login/logout\">退出</a>");
			} else {
				out.print("<a href=\"/javaweb/login/login\">登录</a>");
			}
		%>
	</div>
	<hr />
	<sitemesh:write property='body' />
</body>
</html>