<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body style="margin: 0px; text-align: center;">
	<div style="width: 400px;">
		<form method="post" action="/javaweb/login/save">
			用户名:<input type="text" name="_username" /><br /> 密码：<input type="password" name="_password" /><br /> <input type="submit" value="登录" />&nbsp;&nbsp;<input type="reset" value="重置" />
		</form>
	</div>
</body>
</html>