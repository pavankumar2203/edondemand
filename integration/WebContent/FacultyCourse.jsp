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

</head>
<body>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script type='text/javascript' src='js/Datedropdown.js'></script>
	<script src="js/bootstrap.min.js"></script>

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

												<!-- Read about Bootstrap dropdowns at http://twbs.github.com/bootstrap/javascript.html#dropdowns -->
												<li><a href="/Ed-On-Demand/entry.jsp">Sign Out</a></li>
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





						<div class="container">
							<div style="overflow: hidden" class="edondem-full-canvas">

								<strong> Welcome ${requestScope['user'].username}. </strong>
								<div class="row">
									<div class="span8 edondem-front-main-section">
										<div class="row-fluid">
											<div class="span8">
												<!-- Your Courses-->
												<div class="edondem-dashboard-section-header">
													<span
														class="edondem-front-section-courselist-header edondem-dashboard-section-header-title">Add
														Course: </span>
												</div>
												<div class="edondem-dashboard-enrollments-list">

													<div class="container"></div>


													<div class="container">
														<input type="hidden" name="alist"
															value="<%=request.getAttribute("readResult")%>">
														<div class="option_table_wrapper">
															<form action="AddReadCourse" method="POST">
																<!--  <select name="course" class="selecter_links">
		<option value="">Select</option>            
                <c:forEach var="item" items="${alist}">
                     <option><c:out value="${item}"/></option>
                </c:forEach>   
            </select>
                 -->
																Course ID: <input type="text" name="ID"> Course
																Name: <input type="text" name="name">
																Description: <input type="text" name="comments">

																<input class="btn" type="submit" value="Submit" />
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
									<a href="/about" class="internal-home edondem-footer-link">About</a><a
										href="/about/contact"
										class="internal-home edondem-footer-link">Contact</a>

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