<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Content.css">

<title>Attendance</title>
</head>
<body>
	<div class="nav">
		<img class="logo" src="Images\logo.png"> <a href="Home.jsp">HOME</a> <a href="Contact.jsp">CONTACT</a> <a
			href="StaffLogin.jsp" class="active">STAFF LOGIN</a> <a href="StudentLogin.jsp">STUDENT
			LOGIN</a>
	</div>

	<hr class="horizonrule">

	<div class="buttons">
		<div class="AddStudent">
			<a href="InsertStudent.jsp"><button>Add Student</button></a>
		</div>
		<div>
			<a href="ViewStudents.jsp"><button>View Students</button></a>
		</div>
		<div>
			<a href="GetAttendance.jsp"><button>Get Attendance</button></a>
		</div>
	</div>
	<div class="Entire_form">

		<div class="First_form">
			<form method="post" id = "attendanceValidation" action="AttendanceController">

				Select Batch: <select name="Batch" id = "Batch">
					<option>Batch61</option>
					<option>Batch62</option>
					<option>Batch63</option>
					<option>Batch64</option>
					<option>Batch65</option>
				</select> <br> Enter Roll No: <input type="text" id = "Roll_No"
					placeholder="Enter Roll Numbers separated by ,:" name="Roll_No" id="roll_number">
					<div id ="parag"></div>
				<br> Attendance Date: <input type="date" name="Date" id = "Date"
					value="<%=java.time.LocalDate.now()%>" required> <br>

				<button type="submit">Submit</button>
			</form>
		</div>
		<div class="Second_form">
			<form method="post" id = "marksValidation" action="MarksController">
				Select Batch: <select name="Batch" id = "Batch">
					<option>Batch61</option>
					<option>Batch62</option>
					<option>Batch63</option>
					<option>Batch64</option>
					<option>Batch65</option>
				</select> <br> 
				Enter Marks seperated by, Format:57-10:
				<input type="text" name="Marks" id = "Marks"placeholder="input marks(rollNo-maarks) 57-10"> <br>
				Marks Date: 
				<input type="date" name="Date"value="<%=java.time.LocalDate.now()%>" required> 
				<br>
				<button type="submit">Submit</button>
			</form>
		</div>

	</div>
	<div class="foot">
		<footer> © 2025 B-62 - 057 | All Rights Reserved </footer>
	</div>
	<script type="text/javascript" src = "Content.js"></script>
</body>
</html>
