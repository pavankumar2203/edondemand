<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Request</title>
</head>
<body>
<div class="mainContentWrapper wrapper">
		<div id="mainContent" >
			<div id="loginForm">
				<h3>Add or Search a Course</h3>			
				<div class="linespace"></div>
				<form action="searchServlet" method="POST" name="addform">
					<input type="text" name="searchReqeust" id="searchRequest" class="formBox" />
					<input class="button" type="submit" name="formBtnSubmit" value="Search Course" />
				</form>	
				
				<div class="linespace"></div>
				<div class="linespace"></div>
				
				<form action="addCourseServlet" method="POST" name="addform">
					<table cellspacing="10" border="0" >
						<col align="left" width="100"/>
						<col align="left" width="280"/>
						<tr>
							<td class="fldLabel">Course Name:</td>
							<td><input type="text" name="courseName" id="courseName" class="formBox" value="" /></td>
						</tr>
						<tr>
							<td class="fldLabel">Credits:</td>
							<td><input type="text" name="credits" id="credits" class="formBox" value="" /></td>
						</tr>
						<tr>
							<td class="fldLabel">Category:</td>
							<td><input type="text" name="category" id="category" class="formBox"  /></td>
						</tr>
					</table>			
					<input class="button" type="submit" name="formBtnSubmit" value="Add Course"  />
				</form>	
				<p class="errorMsg">${message}</p> 
			</div>
			<div id="mainContentRight" class="fl-rigth"></div>
			<div class="clear"></div>				
		</div>
	</div>
</body>
</html>