<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>

<body background="img/education.jpg" style="position:relative;left:350px">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<div class="container">
		<form class="form-horizontal" action="LoginController1" method="post">

			<div class="control-group">
				<label class="control-label" for="username">Username</label>
				<div class="controls">
				<input type="text" name="username"
				placeholder="Type your username">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<input type="password" name="password" placeholder="Type password">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <input type="checkbox">
						Remember me
					</label>
					<button type="submit" class="btn">Sign in</button>
				</div>
			</div>

		</form>
	</div>
</body>
</html>