<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="css/style.css">-->
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	%>
	<%
	if (user != null) {
	%>
	<h2><%="Hii, " + user.getFirstName()%></h2>
	<a href="st_marksheetCtl">Student MarkSheet</a> |
	<a href="MarkSheetCtl">MarkSheet</a> |
	<a href="LoginCtl?operation=logout">Logout</a> |
	<%
	} else {
	%>
	<h2>Hii, Guest</h2>
	<a href="LoginCtl">SignIn</a> |
	<a href="UserRegistrationCtl">SignUp</a> |
	<%
	}
	%>
	<a href="WelcomeCtl">welcome</a> | 
	<hr>
</body>
</html>
