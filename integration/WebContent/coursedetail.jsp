<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href='css/calendar.css' rel='stylesheet' type='text/css'>
</head>
<body background="img/education.jpg">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script type='text/javascript' src='js/Datedropdown.js'></script>
	<script src="js/bootstrap.min.js"></script>

	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="#">${requestScope['user'].username}</a>
			<!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<!-- Read about Bootstrap dropdowns at http://twbs.github.com/bootstrap/javascript.html#dropdowns -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="nav-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!-- /.navbar-inner -->
	</div>


	</br>The following is the course details:
	</br>
	<strong>
		<div class="container">
			<table id="tableSelect" class="table " style="display: grid;">
				<tr class="success">
					<td>CourseID</td>
					<td>${requestScope['coursedetails'].requestid}</td>
				</tr>
				<tr class="success">
					<td>CourseTitle</td>
					<td>${requestScope['coursedetails'].course}</td>
				</tr>
				<tr class="info">
					<td>CourseCategory</td>
					<td>${requestScope['coursedetails'].category}</td>
				</tr>
				<tr class="info">
					<td>Number of Credits</td>
					<td>${requestScope['coursedetails'].offer}</td>
				</tr>

			</table>
		</div>

		<div class="container">

			<form action="UploadServlet" method="post"
				enctype="multipart/form-data">
				<input class="btn" type="file" name="file" />
				<div class="control-group">
					<label class="control-label" for="Video">Upload Demo Video</label>
					<div class="controls">
						<input class="btn btn-primary" type="submit" name="Video"
							value="Upload File" style="height: 40px;">
					</div>
				</div>


			</form>

<p>
${requestScope['fileupload']}
</p>
			<form class="form-horizontal" action="sendEmail" method="post">


				<div class="control-group">
					<label class="control-label" for="Time">Time</label>
					<div class="controls">
						<input type="text" name="Time" placeholder="Type time">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="data">Date</label>
					<div class="controls">


						<input type='text' id='sel' name='Date' onclick='dispCal()' size=10
							readonly='readonly' style='cursor: pointer;' /> <img
							src='img/calendar.png' onclick='dispCal()'
							style='cursor: pointer; vertical-align: middle;' />
						<table class='calendar' id='calendar' border=0 cellpadding=0
							cellspacing=0>
							<tr class='monthdisp'>
								<td class='navigate' align='left'><img
									src='img/previous.png' onclick='return prev()' /></td>
								<td align='center' id='month'></td>
								<td class='navigate' align='right'><img src='img/next.png'
									onclick='return next()' /></td>
							</tr>
							<tr>
								<td colspan=3>
									<table id='dispDays' border=0 cellpadding=4 cellspacing=4>
									</table>
								</td>
							</tr>
						</table>



					</div>
				</div>

				<input class="btn btn-primary" type="submit" name="s"
					value="SendEmail" style="height: 40px;" />
			</form>
		</div>
	</strong>
</body>
</html>