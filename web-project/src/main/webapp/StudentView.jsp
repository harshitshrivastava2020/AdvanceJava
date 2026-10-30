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
	%>
	<%@ include file="Header.jsp"%>
	<div class="form-container-wrapper" align="center" style="margin-top: 2%;">
		<form action="StudentCtl" method="post" class="form-table-card">
			<div align="center">

				<div class="form-header">
					<h2>Add Student</h2>
				</div>


				<%=successMsg != null ?"<h2 class='alert-success'>"+ successMsg + "</h2>" : ""%></h2>

				<table class="form-content-table">

					<tr>
						<th>FirstName</th>
						<td><input type="text" name="firstName" value=""
							placeholder="enter your first name"></td>
					</tr>
					<tr>
						<th>LastName</th>
						<td><input type="text" name="lastName" value=""
							placeholder="enter your first name"></td>
					</tr>
					<tr>
						<th>Mobile Number</th>
						<td><input type="number" name="mobileNo" value=""
							placeholder="enter your Mobile name"></td>
					</tr>
					<tr>
						<th>Subject</th>
						<td><input type="text" name="subject" value=""
							placeholder="enter your subject"></td>
					</tr>
					<tr>
						<th>Age</th>
						<td><input type="number" name="age" value=""
							placeholder="enter your age"></td>
					</tr>
					<tr>
						<th>Gender</th>
						<td><input type="text" name="gender" value=""
							placeholder="enter your gender"></td>
					</tr>
					<tr>
						<th>City</th>
						<td><input type="text" name="city" value=""
							placeholder="enter your city"></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" name="operation" value="save" class="btn-submit"></td>
				</table>

			</div>
		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>