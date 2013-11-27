<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body background="img/education.jpg" style="position:relative;left:350px">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
<form action="FacultyDetails" method="POST">
Name: <input type="text" name="name">
<br/>
Skills: <input type="text" name="skills">
<br/>
Email: <input type="text" name="email">
<br/>
Phone: <input type="text" name="phone">
<br/>
Certification: <input type="text" name="certi">
<br/>
Profession: <input type="text" name="profession">
<br/>
<input class="btn" type="submit" value="Submit">
</form>
</body>
</html>