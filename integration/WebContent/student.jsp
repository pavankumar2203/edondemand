<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Profile</title>
</head>
<body>
	<div id="mainContentWrapper" class="wrapper clear">
		<div id="mainContent">
			<div class="dataForm">
				<h2>Student Information</h2>
				<form action="request.jsp" method="post">
					<table border="0" cellspacing="15" width="80%" id="dataTable">
						<col align="right" width="150"/>
						<col align="left" width="400"/>						
						<tr>
							<td class="fldLabel">First Name:</td>
							<td>${student.studFname}</td>
						</tr>
						<tr>
							<td class="fldLabel">Last Name:</td>
							<td>${student.studLname}</td>
						</tr>
						<tr>
							<td class="fldLabel">Gender:</td>
							<td>${student.studGender}</td>
						</tr>
						<tr>
							<td class="fldLabel">Age:</td>
							<td>${student.studAge}</td>
						</tr>
						<tr>
							<td class="fldLabel">Email:</td>
							<td>${student.studEmail}</td>
						</tr>
						<tr>
							<td class="fldLabel">Score:</td>
							<td>${student.studScore}</td>
						</tr>
					</table>
					<div class="linespace"></div>
					<input class="button fl-left" type="submit" value="Search Courses">
				</form>
				<p class="errorMsg">${message}</p>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>