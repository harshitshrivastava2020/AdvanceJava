<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div align="center">
		<form action="MarkSheetCtl" method="post">
			<div align="center">

				<h1>User MarkSheet</h1>

				<table>

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
						<td><input type="numder" name="chemistry" value=""
							placeholder="enter chemistry marks"></td>
					</tr>
					<tr>
						<th>Maths Marks</th>
						<td><input type="number" name="maths" value=""
							placeholder="enter maths marks"></td>
					</tr>

					<tr>
						<th></th>
						<td><input type="submit" name="operation" value="save"></td>
				</table>

			</div>
		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>