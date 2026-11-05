<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.bean.StudentBean"%>
<%@page import="java.util.List"%>
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
	<%
	List<StudentBean> list = (List) request.getAttribute("studentList");
	Iterator<StudentBean> it = list.iterator();
	int pageNo = (int) request.getAttribute("pageNo");
	String successMsg = (String) request.getAttribute("successMsg");
	String errorMsg = (String) request.getAttribute("errorMsg");
	%>
	<%@ include file="Header.jsp"%>

	<form action="StudentListCtl" method="post">
		<input type="hidden" name="pageNo" value="<%=pageNo%>">

		<div class="content-list-data" align="center">
			<div class="table-wrapper-container">
				<h2 style="color: green; margin-top: -78px"><%=successMsg != null ? successMsg : ""%></h2>
				<h2 style="color: red"><%=errorMsg != null ? errorMsg : ""%></h2>
				<table class="content-table" width="70%">
					<thead>
						<tr class="active-row">
							<th>Delete</th>
							<th>Id</th>
							<th>FirsName</th>
							<th>LastName</th>
							<th>Mobile</th>
							<th>Subject</th>
							<th>Age</th>
							<th>Gender</th>
							<th>City</th>
						</tr>
					</thead>
					<tbody>

						<%
						while (it.hasNext()) {
							StudentBean bean = it.next();
						%>
						<tr>
							<td><input type="checkbox" name="ids"
								value="<%=bean.getId()%>"></td>
							<td><%=bean.getId()%></td>
							<td><%=bean.getFirstName()%></td>
							<td><%=bean.getLastName()%></td>
							<td><%=bean.getMobile()%></td>
							<td><%=bean.getSubject()%></td>
							<td><%=bean.getAge()%></td>
							<td><%=bean.getGender()%></td>
							<td><%=bean.getCity()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<table class="pagination-controls" width="70%">
					<tr>
						<td><input type="submit" class="btn-page" name="operation"
							value="previous" <%=pageNo == 1 ? "disabled" : ""%>></td>
						<td align="center"><input type="submit" class="btn-page"
							name="operation" value="delete"></td>
						<td align="right"><input type="submit" class="btn-page"
							name="operation" value="next"
							<%=list.size() < 5 ? "disabled" : ""%>></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	<%@ include file="Footer.jsp"%>

</body>
</html>