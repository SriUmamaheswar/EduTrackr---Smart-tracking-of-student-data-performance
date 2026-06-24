<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Model.Model, com.DAO.AttendanceDAO" %>
<%
    String rollNo = request.getParameter("rollNo");
	String Batch = request.getParameter("Batch");
AttendanceDAO dao = new AttendanceDAO();
    Model student = dao.getStudentByRollNo(Integer.parseInt(rollNo),Batch);
%>
<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet" type="text/css"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Content.css">
</head>
<body>
 <div class="nav">
        <img class="logo" src="Images\logo.png"> 
        <a href="Home.jsp" class="active">HOME</a> 
        <a href="Contact.jsp">CONTACT</a> 
        <a href="StaffLogin.jsp" class="active">STAFF LOGIN</a>
        <a href="StudentLogin.jsp">STUDENT LOGIN</a> 
    </div>
    <h2>Edit Student: <%= student.getStudent_Name() %></h2>
    <div class="editForm">
    <form action="StudentController" method="post">
        <input type="hidden" name="rollNo" value="<%= student.getRoll_No() %>"/>

        <!-- Show current details for update -->
        Name: <input type="text" name="name" value="<%= student.getStudent_Name() %>"/><br/>
        Marks: <input type="text" name="marks" value="<%= student.getAvg_Marks() %>"/><br/>
        Phone: <input type="text" name="phone" value="<%= student.getPhone() %>"/><br/>
        Email: <input type="text" name="email" value="<%= student.getEmail() %>"/><br/>

        <!-- Action buttons -->
        <button type="submit" name="action" value="update">Update</button>
        <button type="submit" name="action" value="delete">Delete</button>
    </form>
    </div>
    <div class="foot">
		<footer> © 2025 B-62 - 057 | All Rights Reserved </footer>
	</div>
</body>
</html>