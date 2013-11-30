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
<link href="css/home.css" rel="stylesheet" media="screen">
</head>
<body background="img/education.jpg">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<div id="origami">
		<div>
			<div>
				<div class="edondem-page">
					<div role="menubar" class="edondem-header">
						<div class="container">
							<div class="row">
								<div class="edondem-header-primary">
									<a href="/Ed-On-Demand/entry.jsp"
										class="internal-home edondem-logo"></a>
								</div>
								<div style="float: left;" class="edondem-header-secondary">
									<span style="margin: 0px 0px 0px 37px; color: #717171;">
										| </span><span class="edondem-header-university-label">Accounts</span>
								</div>
							</div>
						</div>
					</div>
					<div role="navigation" class="edondem-banner"></div>
					<div role="article" class="edondem-body">
						<div class="container">
							<div class="edondem-full-canvas">
								<div class="row">
									<div class="span12">
										<div class="heading-banner">
											<a href="https://Ed-on-Demand/about/reporter?area=signin"
												target="_blank" style="display: none;"
												class="edondem-reporter-link">Help</a>
											<h1>Sign In</h1>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="span6 auth-border-right">
										<div style="padding-top: 20px;">
											<form action="loginServlet" method="POST" name="loginform">
												<div id="signin-fail" role="alert" aria-live="assertive"
													class="control-group hide error">
													<span class="help-inline">Login did not work, check
														your email and password and try again.</span>
												</div>
												<div id="signin-error" role="alert" aria-live="assertive"
													class="control-group hide error">
													<span class="help-inline">Sorry, but we ran into an
														error trying to process your request. please try again
														later or contact <a href="mailto:technical@edondem.org">technical@edondem.org</a>
														for more help.
													</span>
												</div>
												<div class="control-group">
													<label for="signin-email">Email</label>
													<div class="controls">
														<input type="text" title="Your Email Address" id="userId"
															name="userId">
													</div>
												</div>
												<div class="control-group">
													<label for="signin-password">Password</label>
													<div class="controls">
														<input type="password" title="Your Password" name="pwd"
															id="pwd">
													</div>
												</div>

												<div class="control-group">
													<select name="loginas">
														<option>Student</option>
														<option>Professor</option>
													</select>
												</div>

												<div>
													<div class="control-group">
														<div class="controls">
															<button type="submit" style="margin-right: 10px"
																class="btn btn-success edondem-signin-button">Sign
																In</button>
															<button class="btn edondem-signin-button-waiting hide">
																<img
																	src="https://d2wvvaown1ul17.cloudfront.net/site-static/images/icons/loading.gif">
															</button>
															<a href="/reset" class="internal-auth">&nbsp;&nbsp;&nbsp;
																forgot password?</a>
															<p class="errorMsg">${message}</p>
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>
									<div style="margin-left: -1px;" class="span5">
										<div style="padding: 20px;">
											<h3>No Account Yet?</h3>
											<p>
												<a href="/signup" class="internal-auth">Sign up</a>&nbsp;today.
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div role="menubar" class="edondem-footer">
					<div class="container">
						<div class="row-fluid">
							<div class="edondem-footer-content-primary">
								<a href="#" class="edondem-footer-link">About</a><a href="#"
									class="edondem-footer-link">Contact</a>
							</div>
							<!-- <div class="edondem-footer-content-secondary"><a target="_blank" href="#" title="Follow edondem on Google Plus" class="edondem-footer-link">Google+</a><a target="_blank" href="#" class="edondem-footer-link">Twitter</a><a target="_blank" href="#" class="edondem-footer-link">Facebook</a><a target="_blank" href="#"
                            title="Read the edondem blog" class="edondem-footer-link">Blog</a> 
                        </div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>