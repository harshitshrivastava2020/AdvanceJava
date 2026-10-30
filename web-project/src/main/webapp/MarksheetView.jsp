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
	<div class="form-container-wrapper" align="center">
		<form action="MarkSheetCtl" method="post" class="form-table-card">
			<div align="center">

			<div class="form-header">
				<h2>User MarkSheet</h2>
			</div>
				<%=successMsg != null ? "<h2 class='alert-success'>"+ successMsg + "</h2>" : ""%>

				<table class="form-content-table">

					<tr>
						<th>Name</th>
						<td><input type="text" name="name" value=""
							placeholder="enter your first name"></td>
					</tr>
					<tr>
						<th>Roll Number</th>
						<td><input type="number" name="rollNo" value=""
							placeholder="enter your last name"></td>
					</tr>
					<tr>
						<th>Physics Marks</th>
						<td><input type="number" name="physics" value=""
							placeholder="enter physics marks"></td>
					</tr>
					<tr>
						<th>Chemistry Marks</th>
						<td><input type="number" name="chemistry" value=""
							placeholder="enter chemistry marks"></td>
					</tr>
					<tr>
						<th>Maths Marks</th>
						<td><input type="number" name="maths" value=""
							placeholder="enter maths marks"></td>
					</tr>

					<tr class="action-row">
						<th></th>
						<td><input type="submit" name="operation" value="save" class="btn-submit"></td>
				</table>

			</div>
		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>