<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<h1>hello view</h1>

		<form action="HelloServlet" method="post">
			<div align="center">

				<h1>User Form</h1>

				<table>

					<tr>
						<th>First name</th>
						<td><input type="text" name="firstName" value=""
							placeholder="enter your first name"></td>
					</tr>
					<tr>
						<th>Last name</th>
						<td><input type="text" name="lastName" value=""
							placeholder="enter your last name"></td>
					</tr>
					<tr>
						<th>Login</th>
						<td><input type="email" name="login" value=""
							placeholder="enter your email"></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="password" name="password" value=""
							placeholder="enter your password"></td>
					</tr>
					<tr>
						<th>DOB</th>
						<td><input type="date" name="dob" value=""></td>
					</tr>

					<tr>
						<th></th>
						<td><input type="submit" name="operation" value="save"></td>
				</table>

			</div>
		</form>

	</div>

</body>
</html>