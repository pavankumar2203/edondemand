<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Request</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/home.css" rel="stylesheet" media="screen">
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
											<li><a href="/Ed-On-Demand/StudProfile">Edit Profile</a></li>
												<li ><a href="/Ed-On-Demand/student.jsp">Home</a></li>

												<li class="active"><a href="/Ed-On-Demand/request.jsp">Search
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
																Add / Search a course <small id="edondem-profile-editor-status"
																	style="font-size: 12px; line-height: 12px;"></small>
															</h1>
														</div>
													</div>
												</div>
												<div class="edondem-dashboard-enrollments-list">

													<div class="container"></div>


													<div class="container">
														<form action="searchServlet" method="POST" name="addform" class="form-horizontal">
															<input type="search" name="searchReqeust"
																id="searchRequest" class="formBox"  placeholder="Search"/> <input
																class="btn" type="submit" name="formBtnSubmit"
																value="Search Course"/>
														</form>


													</div>


													<div class="container">
														<form action="addCourseServlet" method="POST"
															name="addform">
															<table cellspacing="10" border="0">
																<col align="left" width="100" />
																<col align="left" width="280" />
																<tr>
																	<td class="fldLabel">Course Name:</td>
																	<td><input type="text" name="courseName"
																		id="courseName" class="formBox" value="" /></td>
																</tr>
																<tr>
																	<td class="fldLabel">Credits:</td>
																	<td><input type="text" name="credits" id="credits"
																		class="formBox" value="" /></td>
																</tr>
																<tr>
																	<td class="fldLabel">Category:</td>
																	<td><input type="text" name="category"
																		id="category" class="formBox" /></td>
																</tr>
															</table>
															<input class="btn" type="submit" name="formBtnSubmit"
																value="Add Course" />
														</form>
														<p class="errorMsg">${message}</p>

														<div class="clear"></div>

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
								<a href="http://williamwuyz.wix.com/edondemand" class="internal-home edondem-footer-link">About</a><a
									href="/about/contact" class="internal-home edondem-footer-link">Contact</a>

							</div>
						
							<div class="edondem-footer-content-secondary">
								<a target="_blank" href="https://plus.google.com/"
									title="Follow edondem on Google Plus"
									class="edondem-footer-link">Google+</a><a target="_blank"
									href="https://twitter.com/" title="Follow edondem on Twitter"
									class="edondem-footer-link">Twitter</a><a target="_blank"
									href="http://www.facebook.com/" title="Follow edondem on Facebook"
									class="edondem-footer-link">Facebook</a><a target="_blank"
									href="http://googleblog.blogspot.com/" title="Read the edondem blog"
									class="edondem-footer-link">Blog</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>