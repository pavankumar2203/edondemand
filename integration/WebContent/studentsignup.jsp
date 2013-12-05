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
<link href="css/home.css" rel="stylesheet" media="screen">
<link href='css/calendar.css' rel='stylesheet' type='text/css'>
</head>
<body
	style="background-image: url('img/education.jpg'); background-attachment: fixed;">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script type='text/javascript' src='js/Datedropdown.js'></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$('#tableSelect tr').click(function() {
			$(this).find('th input:radio').prop('checked', true);
		})
	</script>

	<div id="origami">
		<div>
			<div>
				<div class="edondem-page">
					<div role="menubar" class="edondem-header">
						<div class="container">
							<div class="">




								<div class="navbar navbar-inverse">
									<div class="navbar-inner">
										<!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
										<!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
										<!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
										<div class="nav-collapse collapse">
											<ul class="nav">
												<li><a href="/Ed-On-Demand/FacultyDetails">Edit
														Profile</a></li>
												<li><a href="#">Home</a></li>

												<li><a href="/Ed-On-Demand/FacultyCourse.jsp">Add
														Course</a></li>

												<li><a href="/Ed-On-Demand/entry.jsp">Sign Out</a></li>
												<!-- Read about Bootstrap dropdowns at http://twbs.github.com/bootstrap/javascript.html#dropdowns -->

											</ul>
										</div>
										<!--/.nav-collapse -->
									</div>
									<!-- /.navbar-inner -->
								</div>


							</div>
						</div>


					</div>
					<div role="navigation" class="edondem-banner"></div>
					<div role="article" class="edondem-body">





						<div class="container">
							<div style="overflow: hidden" class="edondem-full-canvas">

								<form id="frm" action="addStudentServlet" method="post">
									<h3>You will sign up as a student.</h3>
									<p>* indicates required fields</p>
									<table cellspacing="10">
										<col align="left" width="130" />
										<col align="left" />
										<col align="left" />
										<tr>
											<td class="fldLabel">First Name</td>
											<td><input type="text" name="studFname" id="studFname"
												class="formBox" value="" /></td>
											<td>*</td>
										</tr>
										<tr>
											<td class="fldLabel">Last Name</td>
											<td><input type="text" name="studLname" id="studLname"
												class="formBox" value=""></td>
											<td>*</td>
										</tr>
										<tr>
											<td class="fldLabel">Gender</td>
											<td><input type="text" name="studGender" id="studGender"
												class="formBox" value=""></td>
											<td>*</td>
										</tr>
										<tr>
											<td class="fldLabel">Age</td>
											<td><input type="text" name="studAge" id="studAge"
												class="formBox" value=""></td>
											<td>(Optional)</td>
										</tr>
										<tr>
											<td class="fldLabel">Email</td>
											<td><input type="text" name="studEmail" id="studEmail"
												class="formBox" value=""></td>
											<td>*</td>
										</tr>



										<tr>
											<td class="fldLabel">Password</td>
											<td><input type="password" name="password" id="password"
												class="formBox" value=""></td>
											<td>*</td>
										</tr>


										<tr>
											<td class="fldLabel">Confirm Password</td>
											<td><input type="password" name="confirmpassword"
												id="password" class="formBox" value=""></td>
											<td>*</td>
										</tr>

									</table>
									<input type="submit" value="Sign Up" class="btn"  style = "height: 40px;">
								</form>
								<br class="clear" /> <br class="clear" />
								<form action="index.jsp" method="post">
									<input type="submit" value="Already have an account?"
										class="btn" style = "height: 40px;">
								</form>
								<p class="errorMsg">${message}</p>


							</div>
						</div>
					</div>
				</div>
				<div role="menubar" class="edondem-footer">
					<div class="container">
						<div class="row-fluid">
							<div class="edondem-footer-content-primary">
								<a href="http://williamwuyz.wix.com/edondemand"
									class="internal-home edondem-footer-link">About</a><a
									href="/about/contact" class="internal-home edondem-footer-link">Contact</a>

							</div>

							<div class="edondem-footer-content-secondary">
								<a target="_blank" href="https://plus.google.com/"
									title="Follow edondem on Google Plus"
									class="edondem-footer-link">Google+</a><a target="_blank"
									href="https://twitter.com/" title="Follow edondem on Twitter"
									class="edondem-footer-link">Twitter</a><a target="_blank"
									href="http://www.facebook.com/"
									title="Follow edondem on Facebook" class="edondem-footer-link">Facebook</a><a
									target="_blank" href="http://googleblog.blogspot.com/"
									title="Read the edondem blog" class="edondem-footer-link">Blog</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>