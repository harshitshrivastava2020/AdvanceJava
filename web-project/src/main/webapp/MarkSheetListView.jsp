<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.bean.MarkSheetBean"%>
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
	List<MarkSheetBean> list = (List) request.getAttribute("marksheetList");
	Iterator<MarkSheetBean> it = list.iterator();
	%>
	<%@ include file="Header.jsp"%>
	<form>
		<div class="content-list-data" align="center">
			<table class="content-table" width="70%">
				<thead>
					<tr class="active-row">
						<th>Id</th>
						<th>RollNo</th>
						<th>Name</th>
						<th>Physics</th>
						<th>Chemistry</th>
						<th>Maths</th>
					</tr>
				</thead>
				<tbody>

					<%
					while (it.hasNext()) {
						MarkSheetBean bean = it.next();
					%>
					<tr>
						<td><%=bean.getId()%></td>
						<td><%=bean.getRollNo()%></td>
						<td><%=bean.getName()%></td>
						<td><%=bean.getPhysics()%></td>
						<td><%=bean.getChemistry()%></td>
						<td><%=bean.getMaths()%></td>
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