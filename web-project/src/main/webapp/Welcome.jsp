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
	<%@ include file="Header.jsp"%>
	<div class="content-list-data" align="center">
		<h1>
			Welcome to User Management System(<%=user != null ? user.getFirstName() : "Guest"%>)
		</h1>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>