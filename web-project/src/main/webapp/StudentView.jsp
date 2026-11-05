<%@page import="in.co.rays.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
	String successMsg = (String) request.getAttribute("successMsg");
	StudentBean bean = (StudentBean) request.getAttribute("bean");
	%>
	<%@ include file="Header.jsp"%>
	<div class="form-container-wrapper" align="center"
		style="margin-top: 2%;">
		<form action="StudentCtl.do" method="post" class="form-table-card">
			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">
			<div align="center">

				<div class="form-header">
					<h2><%=bean != null ? "Update Student" : "Add Student"%></h2>
				</div>


				<%=successMsg != null ? "<h2 class='alert-success'>" + successMsg + "</h2>" : ""%></h2>

				<table class="form-content-table">

					<tr>
						<th>FirstName</th>
						<td><input type="text" name="firstName"
							value="<%=bean != null ? bean.getFirstName() : ""%>"
							placeholder="enter your first name"></td>
					</tr>
					<tr>
						<th>LastName</th>
						<td><input type="text" name="lastName"
							value="<%=bean != null ? bean.getLastName() : ""%>"
							placeholder="enter your first name"></td>
					</tr>
					<tr>
						<th>Mobile Number</th>
						<td><input type="number" name="mobileNo"
							value="<%=bean != null ? bean.getMobile() : ""%>"
							placeholder="enter your Mobile name"></td>
					</tr>
					<tr>
						<th>Subject</th>
						<td><input type="text" name="subject"
							value="<%=bean != null ? bean.getSubject() : ""%>"
							placeholder="enter your subject"></td>
					</tr>
					<tr>
						<th>Age</th>
						<td><input type="number" name="age"
							value="<%=bean != null ? bean.getAge() : ""%>"
							placeholder="enter your age"></td>
					</tr>
					<tr>
						<th>Gender</th>
						<td><input type="text" name="gender"
							value="<%=bean != null ? bean.getGender() : ""%>"
							placeholder="enter your gender"></td>
					</tr>
					<tr>
						<th>City</th>
						<td><input type="text" name="city"
							value="<%=bean != null ? bean.getCity() : ""%>"
							placeholder="enter your city"></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" name="operation"
							value="<%=bean != null ? "Update" : "Add"%>" class="btn-submit"></td>
				</table>

			</div>
		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>