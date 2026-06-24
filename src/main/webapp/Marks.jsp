<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*,com.Model.Model"%>
<%
    List <Model> a = (List<Model>) request.getAttribute("mm");
%>
<html>
<head>
    <title>Student Details</title>
    <link rel="stylesheet" type="text/css" href="Content.css">
</head>
<body>
 <div class="nav">
        <img class="logo" src="Images\logo.png"> 
        <a href="Home.jsp">HOME</a> 
        <a href="Contact.jsp">CONTACT</a> 
        <a href="StaffLogin.jsp" >STAFF LOGIN</a>
        <a href="StudentLogin.jsp" class="active">STUDENT LOGIN</a> 
    </div>
<%--     <h2>Student Data: <%= (batch != null ? batch : "Unknown") %></h2> --%>

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
        <% for (Model studentdata : a) { %>
        <tr>
            <td><%= studentdata.getRoll_No() %></td>
            <td><%= studentdata.getStudent_Name() %></td>
            <td><%= studentdata.getAvg_Marks() %></td>
            <td><%= studentdata.getPhone() %></td>
            <td><%= studentdata.getEmail() %></td>
<%--             <td><a href="EditStudent.jsp?rollNo=<%= studentdata.getRoll_No() %>&Batch=<%= batch %>">Edit</a></td> --%>
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