<%@page import="in.co.rays.bean.MarkSheetBean"%>
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
	MarkSheetBean bean = (MarkSheetBean) request.getAttribute("bean");
	%>
	<%@ include file="Header.jsp"%>
	<div class="form-container-wrapper" align="center">
		<form action="MarkSheetCtl.do" method="post" class="form-table-card">
			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">
			<div align="center">

				<div class="form-header">
					<h2><%=bean != null ? "Update Marksheet" : "Add Marksheet"%></h2>
				</div>
				<%=successMsg != null ? "<h2 class='alert-success'>" + successMsg + "</h2>" : ""%>

				<table class="form-content-table">

					<tr>
						<th>Name</th>
						<td><input type="text" name="name"
							value="<%=bean != null ? bean.getName() : ""%>"
							placeholder="enter your first name"></td>
					</tr>
					<tr>
						<th>Roll Number</th>
						<td><input type="number" name="rollNo"
							value="<%=bean != null ? bean.getRollNo() : ""%>"
							placeholder="enter your last name"></td>
					</tr>
					<tr>
						<th>Physics Marks</th>
						<td><input type="number" name="physics"
							value="<%=bean != null ? bean.getPhysics() : ""%>"
							placeholder="enter physics marks"></td>
					</tr>
					<tr>
						<th>Chemistry Marks</th>
						<td><input type="number" name="chemistry"
							value="<%=bean != null ? bean.getChemistry() : ""%>"
							placeholder="enter chemistry marks"></td>
					</tr>
					<tr>
						<th>Maths Marks</th>
						<td><input type="number" name="maths"
							value="<%=bean != null ? bean.getMaths() : ""%>"
							placeholder="enter maths marks"></td>
					</tr>

					<tr class="action-row">
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