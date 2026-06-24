<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Login</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Content.css">

</head>
<body>

<div class="nav">
    <img class="logo" src="Images/logo.png"> 
    <a href="Home.jsp">HOME</a> 
    <a href="Contact.jsp">CONTACT</a> 
    <a href="StaffLogin.jsp" class="active">STAFF LOGIN</a>
    <a href="StudentLogin.jsp">STUDENT LOGIN</a> 
</div>

<div class="login-container">
    <form method="post" id="staffLoginValidation" action = "StaffLoginController">

        <label>UserName</label>
        <input type="text" name="username" placeholder="username" required>

        <label>Password</label>
        <input type="password" id="psw" name="password" placeholder="Password" required>
        <div id="c-psw"></div>
        <p id="msg"></p>

        <button type="submit" id = "stafff" class="btn btn-primary btn-block">Submit</button>
    </form>
</div>

<div class="foot">
    <footer> © 2025 B-62 - 057 | All Rights Reserved </footer>
</div>

<script type="text/javascript" src="Content.js"></script>

</body>
</html>
