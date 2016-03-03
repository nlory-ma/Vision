<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en" class=" ">
<head>
<meta charset="utf-8" />
<title>Scale | Web Application</title>
<meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="resources/scale/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="resources/scale/css/animate.css" type="text/css" />
<link rel="stylesheet" href="resources/scale/css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="resources/scale/css/icon.css" type="text/css" />
<link rel="stylesheet" href="resources/scale/css/font.css" type="text/css" />
<link rel="stylesheet" href="resources/scale/css/app.css" type="text/css" />
<!--[if lt IE 9]>
    <script src="resources/scale/js/ie/html5shiv.js"></script>
    <script src="resources/scale/js/ie/respond.min.js"></script>
    <script src="resources/scale/js/ie/excanvas.js"></script>
  <![endif]-->
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
<body class="">
	<section id="content" class="m-t-lg wrapper-md animated fadeInUp">
		<div class="container aside-xl">
			<a class="navbar-brand block" href="index.html">vLokal</a>
			<section class="m-b-lg">
				<header class="wrapper text-center">
					<strong>Sign in to get in touch</strong>
				</header>
				<form name='loginForm' action="<c:url value='/loginCheck' />" method='POST'>
					<div class="list-group">
						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
						<div class="list-group-item">
							<input type="email" placeholder="Email" class="form-control no-border" name="username">
						</div>
						<div class="list-group-item">
							<input type="password" placeholder="Password" class="form-control no-border" name="password">
						</div>
					</div>
					<input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in" name="submit" /> <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="text-center m-t m-b">
						<a href="#"><small>Forgot password?</small></a>
					</div>
					<!-- 					<div class="line line-dashed"></div> -->
					<!-- 					<p class="text-muted text-center"> -->
					<!-- 						<small>Do not have an account?</small> -->
					<!-- 					</p> -->
					<!-- 					<a href="signup.html" class="btn btn-lg btn-default btn-block">Create an account</a> -->
				</form>
			</section>
		</div>
	</section>
	<!-- footer -->
	<!-- / footer -->
	<script src="resources/scale/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="resources/scale/js/bootstrap.js"></script>
	<!-- App -->
	<script src="resources/scale/js/app.js"></script>
	<script src="resources/scale/js/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="resources/scale/js/app.plugin.js"></script>
</body>
</html>