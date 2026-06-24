<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student</title>
<link rel="stylesheet" type="text/css"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Content.css">
</head>
<body>

    <div class="nav">
        <img class="logo" src="Images\logo.png"> 
        <a href="Home.jsp" class="active">HOME</a> 
        <a href="Contact.jsp">CONTACT</a> 
        <a href="StaffLogin.jsp">STAFF LOGIN</a>
        <a href="StudentLogin.jsp">STUDENT LOGIN</a> 
    </div>

    <div class="insert-container">
        <div class="login">
            <h2>Insert Student</h2>

            <form method="post" id = "insertStudentValidationForm">

                <label>Select Batch</label>
                <select name="Batch">
                    <option>Batch61</option>
                    <option>Batch62</option>
                    <option>Batch63</option>
                    <option>Batch64</option>
                    <option>Batch65</option>
                </select>

                <label>Enter Roll No</label>
                <input type="number" placeholder="Enter Number" name="Roll_No" id="roll_number">

                <label>Enter Student Name</label>
                <input type="text" name="Student_Name" id = "studentName">

                <label>Enter Marks</label>
                <input type="number" name="Avg_Marks" id = "avgMarks">

                <label>Enter Phone Number</label>
                <input type="number" name="Phone" id = "phoneNumber">

                <label>Email</label>
                <input type="email" name="Email" id = "studentMail">
                <div id = "insertStudentValidation"></div>

                <button type="submit" name="login" id = "formButton" value="Submit">Submit</button>
            </form>
            

        </div>
    </div>
    <div class="foot">
		<footer> © 2025 B-62 - 057 | All Rights Reserved </footer>
	</div>
<script type="text/javascript" src="Content.js"></script>

</body>
</html>
