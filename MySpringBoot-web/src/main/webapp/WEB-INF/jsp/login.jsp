<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="userlogin" method="post" >
		<input type="text" name="username">请输入登录名</input>
		<input type="password" name="password">请输入密码</input>
		<input type="submit"></input>
		<div th:text="${message}"></div>
	</form>
</body>
</html>