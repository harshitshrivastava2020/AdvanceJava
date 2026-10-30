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
	%>
	<%@ include file="Header.jsp"%>

	<form>
		<div class="content-list-data"  align="center">
			<table class="content-table" width="70%">
				<thead>
					<tr class="active-row">
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
		</div>
	</form>
	<%@ include file="Footer.jsp"%>

</body>
</html>