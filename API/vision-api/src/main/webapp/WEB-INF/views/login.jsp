<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">

<title>vLokal | Login</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="resources/pivot/css/flexslider.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/pivot/css/line-icons.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/pivot/css/elegant-icons.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/pivot/css/lightbox.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/pivot/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/pivot/css/theme.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/pivot/css/custom.css" rel="stylesheet" type="text/css" media="all" />
<!--[if gte IE 9]>
        	<link rel="stylesheet" type="text/css" href="resources/pivot/css/ie9.css" />
		<![endif]-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,400,300,600,700%7CRaleway:700' rel='stylesheet' type='text/css'>
<script src="resources/pivot/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<div class="loader">
		<div class="spinner">
			<div class="double-bounce1"></div>
			<div class="double-bounce2"></div>
		</div>
	</div>

	<div class="nav-container">
		<nav class="top-bar overlay-bar">
			<div class="container">

				<div class="row utility-menu">
					<div class="col-sm-12">
						<div class="utility-inner clearfix">
							<span class="alt-font"><i class="icon icon_pin"></i> ITPL, Bangalore</span> <span class="alt-font"><i class="icon icon_mail"></i> orders@vlokal.com</span>

							<div class="pull-right">
								<a href="<c:url value='/login' />" class="btn btn-primary login-button btn-xs">Login</a>
							</div>
						</div>
					</div>
				</div>
				<!--end of row-->

				<div class="mobile-toggle">
					<i class="icon icon_menu"></i>
				</div>

			</div>
			<!--end of container-->
		</nav>
	</div>
	<div class="main-container">
		<section class="no-pad login-page fullscreen-element">

			<div class="background-image-holder">
				<img class="background-image" alt="Poster Image For Mobiles" src="resources/pivot/img/hero6.jpg">
			</div>

			<div class="container align-vertical">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 text-center">
						<h1 class="text-white">Login to continue</h1>
						<div class="photo-form-wrapper clearfix">
							<form name='loginForm' action="<c:url value='/loginCheck' />" method='POST'>

								<c:if test="${not empty error}">
									<div class="error">${error}</div>
								</c:if>
								<c:if test="${not empty msg}">
									<div class="msg">${msg}</div>
								</c:if>
								<input class="form-email" type="text" placeholder="Email Address" name="username">
								<input class="form-password" type="password" placeholder="Password" name="password">
								<input class="login-btn btn-filled" type="submit" value="Login" name="submit">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form>
						</div>
						<!--end of photo form wrapper-->
						<!-- 	<a href="#" class="text-white">Create an account</a><br>
						<a href="#" class="text-white">I've forgotten my password</a> -->
					</div>
				</div>
				<!--end of row-->
			</div>
			<!--end of container-->
		</section>
	</div>
	<div class="footer-container"></div>

	<script src="resources/pivot/js/jquery.min.js"></script>
	<script src="resources/pivot/js/jquery.plugin.min.js"></script>
	<script src="resources/pivot/js/bootstrap.min.js"></script>
	<script src="resources/pivot/js/jquery.flexslider-min.js"></script>
	<script src="resources/pivot/js/smooth-scroll.min.js"></script>
	<script src="resources/pivot/js/skrollr.min.js"></script>
	<script src="resources/pivot/js/spectragram.min.js"></script>
	<script src="resources/pivot/js/scrollReveal.min.js"></script>
	<script src="resources/pivot/js/isotope.min.js"></script>
	<script src="resources/pivot/js/twitterFetcher_v10_min.js"></script>
	<script src="resources/pivot/js/lightbox.min.js"></script>
	<script src="resources/pivot/js/jquery.countdown.min.js"></script>
	<script src="resources/pivot/js/scripts.js"></script>
</body>
</html>
