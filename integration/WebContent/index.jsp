<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>ED-On-Demand - Login</title>
	<script src="login.js" type="text/javascript"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>

<body background="img/education.jpg" style="position:relative;left:350px">
<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<div class="mainContentWrapper wrapper">
		<div id="mainContent" >
			<div id="loginForm">
				<h3>Login to your account</h3>
				<form action="loginServlet" method="POST" name="loginform">
					<table cellspacing="10" border="0" >
						<col align="left" width="100"/>
						<col align="left" width="280"/>
						<tr>
							<td class="fldLabel">User Id:</td>
							<td><input type="text" name="userId" id="userId" class="formBox" value="" /></td>
						</tr>
						<tr>
							<td class="fldLabel">Password</td>
							<td><input type="password" name="pwd" id="pwd" class="formBox" value="" /></td>
						</tr>
					</table>			
					<input class="btn  btn-primary" type="button" name="formBtnSubmit" value="Log In" onClick="testResults(this.form)" />
					<p class="errorMsg">${message}</p> 
				</form>				
				<div class="linespace"></div>

				<p class="fl-left">
					<a href="forgetPassword.jsp">Forgot your password?</a>
				</p>
			</div>
			<div id="mainContentRight" class="fl-rigth"></div>
			<div class="clear"></div>				
		</div>
	</div>
</body>
</html>
