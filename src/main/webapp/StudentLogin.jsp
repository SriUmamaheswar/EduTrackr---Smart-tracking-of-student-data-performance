<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Content.css">
</head>
<body>
	<div class="nav">
		<img class="logo" src="Images\logo.png"> <a href="Home.jsp">
		HOME</a> <a href="Contact.jsp">CONTACT</a> <a
			href="StaffLogin.jsp">STAFF LOGIN</a> <a href="StudentLogin.jsp"
			class="active">STUDENT LOGIN</a>
	</div>
	<form id = "studentLoginValidationForm" method="post">
		<div class="login-container">
			<label>Select Batch:</label> <select name="Batch">
				<option>Batch61</option>
				<option>Batch62</option>
				<option>Batch63</option>
				<option>Batch64</option>
				<option>Batch65</option>
			</select> <label>Roll-No:</label> <input type="number" id = "studentUsername" name="username"
				placeholder="Enter User ID"> <label>Password(phoneNo):</label> <input
				type="password" id = "studentPassword" name="password" placeholder="Enter Password">
				<div id = "Logininfo"></div>
			<button type="submit" id = studentLoginFinal>Submit</button>
		</div>
	</form>
	<script type="text/javascript" src = "Content.js"></script>
	
</body>
<div class="foot">
		<footer> © 2025 B-62 - 057 | All Rights Reserved </footer>
	</div>
</html>