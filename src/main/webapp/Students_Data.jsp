

<!-- Retrives the  Students data Based on tghe Batch -->

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*,com.Model.Model"%>
<%
    List<Model> a = (List<Model>) request.getAttribute("mm");
    String batch = request.getParameter("Batch");
%>
<html>
<head>
    <title>Student Data</title>
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
    <h2>Student Data for Batch: <%= (batch != null ? batch : "Unknown") %></h2>

<% if (a != null && !a.isEmpty()) { %>
    <table>
        <tr>
            <th>Roll No</th>
            <th>Name</th>
            <th>Average Marks</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Edit</th>
        </tr>
        <% for (Model student : a) { %>
        <tr>
            <td><%=student.getRoll_No()%></td>
            <td><%=student.getStudent_Name()%></td>
            <td><%=student.getAvg_Marks()%></td>
            <td><%=student.getPhone()%></td>
            <td><%=student.getEmail()%></td>
            <td><a href="EditStudent.jsp?rollNo=<%=student.getRoll_No()%>&Batch=<%=batch%>">Edit</a></td>
        </tr>
        <% } %>
    </table>
<% } else { %>
    <p>No student data available for this batch.</p>
<% } %>
<div class="foot">
		<footer> © 2025 B-62 - 057 | All Rights Reserved </footer>
	</div>
</body>
</html>