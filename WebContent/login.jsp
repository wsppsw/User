<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>欢迎使用学生管理系统-用户登录</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="js/jquery.min.js" type="text/javascript"></script>

<script type="text/javascript">
		function changeValidateCode(){
			document.getElementById("validateCode").src =
				"ValidateCodeServlet?rand=" + Math.random();
		}
		
		
		
	</script>

<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}

.alert-danger {
	border: white;
}

.block {
	color: white;
	font-size: 12px;
	margin: 20px;
	padding: 20px;
	border: 2px 0px 0px 2 px;
	border-radius: 20px;
	background-color: rgba(10%, 20%, 30%, 0.3);
}

body {
	background-image: url(images/slider3.jpg);
}

img {
	hight: 50px;
	width: 90px;
}

a {
	color: white;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements
    .block{
        	background-color:rgb(249,241,202);
        } -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body>


	<%

	String username = "";
	String password = "";
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie cookie: cookies){
			if("COOKIE_USERNAME".equals(cookie.getName())){
				username = cn.wsp.sms.servlet.CookieEncryptTool.decodeBase64(cookie.getValue());
			}
			if("COOKIE_PASSWORD".equals(cookie.getName())){
				password = cn.wsp.sms.servlet.CookieEncryptTool.decodeBase64(cookie.getValue());
			}
		}
	}
%>

	<!--<![endif]-->

	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

			</ul>
			<a class="brand" href="login.jsp"> <span class="second">学生信息管理系统</span></a>
		</div>
	</div>








	<div class="row-fluid">

		<div class="dialog">
			<div class="block">

				<center>
					<h4 class="">用户登录</h4>
				</center>
				<div class="block-body">
				
					<form action="LoginServlet" method="post">
						<div class=" alert-danger">${sessionScope.loginError}</div>
						<label>用户名：</label> <input type="text" class="span12"
							name="username" value="<%=username %>">
						<div class=" alert-danger">${sessionScope.usernameError}</div>

						<label>密码</label> <input type="password" class="span12"
							name="password" value="<%=password %>">
						<div class=" alert-danger">${sessionScope.passwordError}</div>

						<label>验证码</label> <input type="text" class="span12"
							name="validateCode">
						<div class=" alert-danger">${sessionScope.validateCodeError}</div>
						<img src="ValidateCodeServlet" id="validateCode" title="单击换一换"
							onclick="changeValidateCode()" /> <font size="3"><a
							href="javascript:changeValidateCode();">看不清？</a></font>

						<!--  
                    <a href="./main/main.jsp" class="btn btn-primary pull-right">登录</a>
                    -->

						<input class="btn btn-primary pull-right" type="submit" value="登录" />
						<label class="remember-me"><input name="remember"
							id="remember" type="checkbox" value="true" checked="checked">十天内记住密码</label>
					</form>

					<a href="add_user.jsp"><button
							class="btn btn-primary pull-right" class="btn btn-gradient">没有账号?点击这里注册</button></a>
					<div class="clearfix"></div>


				</div>
			</div>
			<!--
        <p class="pull-right" style=""><a href="#" target="blank">Theme by Portnine</a></p>
        <p><a href="reset-password.html">Forgot your password?</a></p>
        -->
		</div>

	</div>

	<%
		session.removeAttribute("validateCodeError");
		session.removeAttribute("usernameError");
		session.removeAttribute("passwordError");
		session.removeAttribute("loginError");
	%>



	<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>

</body>
</html>


