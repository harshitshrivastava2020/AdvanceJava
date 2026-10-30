<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="header-bg">
		<%
		UserBean user = (UserBean) session.getAttribute("user");
		%>
		<%
		if (user != null) {
		%>
		<h2><%="Hii, " + user.getFirstName()%></h2>
		<a href="MarkSheetCtl">Add MarkSheet</a> <span class="pipe">| </span>
		<a href="MarkSheetListCtl">MarkSheet List</a> <span class="pipe">|
		</span> <a href="StudentCtl">Add Student</a> <span class="pipe">| </span> <a
			href="StudentListCtl">Student List</a> <span class="pipe">| </span> <a
			href="LoginCtl?operation=logout">Logout</a> <span class="pipe">|
		</span>
		<%
		} else {
		%>
		<h2>Hii, Guest</h2>
		<a href="LoginCtl">SignIn</a> <span class="pipe">| </span> <a
			href="UserRegistrationCtl">SignUp</a> <span class="pipe">| </span>
		<%
		}
		%>
		<a href="WelcomeCtl">welcome</a> <span class="pipe">| </span>
	</div>
</body>
</html>
