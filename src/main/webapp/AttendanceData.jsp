<%@ page import="java.util.*,com.Model.AttendanceModel" %>
<%
List<AttendanceModel> a = (List<AttendanceModel>) request.getAttribute("a");
%>

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
    <img class="logo" src="Images/logo.png">
    <a href="Home.jsp">HOME</a>
    <a href="Contact.jsp">CONTACT</a>
    <a href="StaffLogin.jsp">STAFF LOGIN</a>
    <a href="StudentLogin.jsp">STUDENT LOGIN</a>
</div>

<div class="attendance-container">

    <h4>Attendance Data</h4>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Email</th>
            </tr>
        </thead>

        <tbody>
            <% for (AttendanceModel aa : a) { %>
            <tr>
                <td><%= aa.getEmail() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    

</div>
<div class="foot">
		<footer> � 2025 B-62 - 057 | All Rights Reserved </footer>
	</div>

</body>
</html>
