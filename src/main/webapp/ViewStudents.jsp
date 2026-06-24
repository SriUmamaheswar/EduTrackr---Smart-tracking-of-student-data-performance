<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance Data</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Content.css">

</head>
<body>

	<div class="nav">
		<img class="logo" src="Images/logo.png"> <a href="Home.jsp"
			class="active">HOME</a> <a href="Contact.jsp">CONTACT</a> <a
			href="StaffLogin.jsp">STAFF LOGIN</a> <a href="StudentLogin.jsp">STUDENT
			LOGIN</a>
	</div>
	<div class="ViewStudents_form">
		<form method="post" action="DataController">
			Select Batch: <select name="Batch">
				<option>Batch61</option>
				<option>Batch62</option>
				<option>Batch63</option>
				<option>Batch64</option>
				<option>Batch65</option>
			</select> <br>
			<button type="submit">Submit</button>
		</form>
	</div>
<div class="foot">
		<footer> © 2025 B-62 - 057 | All Rights Reserved </footer>
	</div>
</body>
</html>