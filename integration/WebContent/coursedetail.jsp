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
<body style="background-image: url('img/education.jpg'); background-attachment:fixed;">
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
								<strong> Welcome ${requestScope['user'].username}. </strong>

								<div class="row">
									<div class="span8 edondem-front-main-section">
										<div class="row-fluid">
											<div class="span8">
												<!-- Your Courses-->
												<div class="row-fluid">
													<div class="span12">
														<div style="margin-bottom: 10px;" class="heading-banner">

															<h1>
																The following is the course details <small
																	id="edondem-profile-editor-status"
																	style="font-size: 12px; line-height: 12px;"></small>
															</h1>
														</div>
													</div>
												</div>
												<div class="edondem-dashboard-enrollments-list">

													<div class="container"></div>


													<div class="container">
														<table id="tableSelect" class="table "
															style="display: grid;">
															
															<tr class="info">
																<td>CourseTitle</td>
																<td>${requestScope['coursedetails'].course}</td>
															</tr>
															<tr class="success">
																<td>CourseCategory</td>
																<td>${requestScope['coursedetails'].category}</td>
															</tr>
															<tr class="info">
																<td>Number of Credits</td>
																<td>${requestScope['coursedetails'].offer}</td>
															</tr>

														</table>

														<form action="UploadServlet" method="post"
															enctype="multipart/form-data" class="form-horizontal">

															<div class="control-group">
																<input class="btn" type="file" name="file"
																	 /> <label class="control-label"
																	for="Video">Upload Demo Video : </label> <input
																	class="btn" type="submit" name="Video" value="Upload"
																	style="height: 40px;">

															</div>


														</form>

														<p>${requestScope['fileupload']}</p>
														<form class="form-horizontal" action="sendEmail"
															method="post">

															<div class="control-group">
																<label class="control-label" for="NoH">Number of Hours</label>
																<div class="controls">
																	<input type="text" name="NoH" placeholder="# of hours">
																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="Time">Time</label>
																<div class="controls">
																	<input type="text" name="Time" placeholder="Type time">
																</div>
															</div>
															<div class="control-group">
																<label class="control-label" for="data">Date</label>
																<div class="controls">


																	<input type='text' id='sel' name='Date'
																		onclick='dispCal()' size=10 readonly='readonly'
																		style='cursor: pointer;' /> <img
																		src='img/calendar.png' onclick='dispCal()'
																		style='cursor: pointer; vertical-align: middle;' />
																	<table class='calendar' id='calendar' border=0
																		cellpadding=0 cellspacing=0>
																		<tr class='monthdisp'>
																			<td class='navigate' align='left'><img
																				src='img/previous.png' onclick='return prev()' /></td>
																			<td align='center' id='month'></td>
																			<td class='navigate' align='right'><img
																				src='img/next.png' onclick='return next()' /></td>
																		</tr>
																		<tr>
																			<td colspan=3>
																				<table id='dispDays' border=0 cellpadding=4
																					cellspacing=4>
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

												</div>

											</div>
										</div>

									</div>
									<div class="span4 edondem-front-sidebar-section"></div>
								</div>


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