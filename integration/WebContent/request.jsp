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
<body>
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
								<div class="edondem-header-primary">
									<a href="/" class="internal-home edondem-logo"></a>
								</div>



								<div class="navbar navbar-inverse">
									<div class="navbar-inner">
										<!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
										<button type="button" class="btn btn-navbar"
											data-toggle="collapse" data-target=".nav-collapse">
											<span class="icon-bar"></span> <span class="icon-bar"></span>
											<span class="icon-bar"></span>
										</button>
										<a class="brand" href="/Ed-On-Demand/FacultyDetails">${requestScope['user'].username}</a>
										<!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
										<div class="nav-collapse collapse">
											<ul class="nav">
												<li class="active"><a href="#">Home</a></li>
												<li><a href="#about">About</a></li>
												<li><a href="#contact">Contact</a></li>
												<!-- Read about Bootstrap dropdowns at http://twbs.github.com/bootstrap/javascript.html#dropdowns -->
												<li class="dropdown"><a href="#"
													class="dropdown-toggle" data-toggle="dropdown">Dropdown
														<b class="caret"></b>
												</a>
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


							</div>
						</div>
						<div id="edondem-header-about-popup"
							class="hide edondem-header-popup">
							<a data-popup-close="data-popup-close" href="/about/jobs"
								class="internal-home">Careers</a><a
								data-popup-close="data-popup-close" href="/about/team"
								class="internal-home">Team</a><a
								data-popup-close="data-popup-close" href="/about/contact"
								class="internal-home">Contact</a><a
								data-popup-close="data-popup-close" href="/about/"
								class="internal-home">About Us</a>
						</div>

					</div>
					<div role="navigation" class="edondem-banner"></div>
					<div role="article" class="edondem-body">


						<strong> Welcome ${requestScope['user'].username}. </strong>


						<div class="container">
							<div style="overflow: hidden" class="edondem-full-canvas">


								<div class="row">
									<div class="span8 edondem-front-main-section">
										<div class="row-fluid">
											<div class="span8">
												<!-- Your Courses-->
												<div class="edondem-dashboard-section-header">
													<span
														class="edondem-front-section-courselist-header edondem-dashboard-section-header-title">Add
														or Search a Course</span>
												</div>
												<div class="edondem-dashboard-enrollments-list">

													<div class="container"></div>


													<div class="container">
														<form action="searchServlet" method="POST" name="addform">
															<input type="text" name="searchReqeust"
																id="searchRequest" class="formBox" /> <input
																class="btn" type="submit" name="formBtnSubmit"
																value="Search Course" />
														</form>


														<p class="errorMsg">${message}</p>



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
								<a href="/about" class="internal-home edondem-footer-link">About</a><a
									href="/about/contact" class="internal-home edondem-footer-link">Contact</a>

							</div>
							<div class="edondem-footer-content-secondary">
								<a target="_blank" href="#"
									title="Follow edondem on Google Plus"
									class="edondem-footer-link">Google+</a><a target="_blank"
									href="#" title="Follow edondem on Twitter"
									class="edondem-footer-link">Twitter</a><a target="_blank"
									href="#" title="Follow edondem on Facebook"
									class="edondem-footer-link">Facebook</a><a target="_blank"
									href="#" title="Read the edondem blog"
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