<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.7.2.min.js" type="main/text/javascript"></script>

<!-- Demo page code -->
<script type="text/javascript">
    
    function changeValidateCode(){
		document.getElementById("validateCode").src =
			"ValidateCodeServlet?rand=" + Math.random();
	}
    
   
    	function postbox(){
    		var xhr = false;
    		function createXHR(){
    			try{
    				xhr = new XMLHttpRequest();
    			}catch(e){
    				try{
    					xhr = new ActiveXObject("Microsoft.XMLHTTP");
    				}catch(e1){
    					xhr = false;
    				}
    			}
    			if(!xhr)
    				alert("初始化XMLTHHPrequest对象失败！");
    		}
    		
    		
    		createXHR();
    		var postbox = document.getElementById('postbox').value;
    		var to2 = document.getElementById('to2').value;
    		var url = "EmailServlet?postbox="+postbox+"&to2="+to2;
    		
    	
    		
    		xhr.open("POST",url,true);
    		
    		xhr.onreadystatechange = function(){
    			if(xhr.readyState == 4 && xhr.status == 200){
    				alert("发送验证码成功！");
    			}
    		}
    		
    		xhr.send();
    	}
    </script>

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

#to2 {
	width: 110px;
}

#validateCode {
	display: none;
}

body {
	background-image: url(images/slide2.jpg);
	height: 300px;
	width: 800px;
	padding-left: 250px;
}

.container-fluid {
	background-color: rgba(10%, 20%, 30%, 0.1);
	border-radius: 15px;
}

.well {
	background-color: rgba(10%, 20%, 30%, 0.2);
	color: white;
	border: 0px 0px 0px 0px;
	border-radius: 20px;
}

a {
	color: white;
}

select {
	background-color: transparent;
}

.headeree {
	background-color: transparent;
	margin-top: 50px;
	color: black;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
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
<body>
	<div>



		<div class="container-fluid">
			<div class="row-fluid">


				<!--
		<div class="btn-toolbar">
			<button class="btn btn-primary"><i class="icon-save"></i> Save</button>
			<a href="#myModal" data-toggle="modal" class="btn">Delete</a>
		</div>
		-->
				<div class="headeree">
					<h1 class="page-title" align="center">注册管理员</h1>
				</div>
				<div class="well">

					<form id="tab" method="post" action="user_add">

						<label>请创建用户名:</label> <input type="text" name="username"
							id="username" class="input-xlarge">
						<div class=" alert-danger">${sessionScope.usernameError}</div>

						<label>请输入密码：</label> <input type="password" name="password"
							id="password" class="input-xlarge"> <label>请再次输入密码：</label>
						<input type="password" name="password1" id="password1"
							class="input-xlarge">

						<div class=" alert-danger">${sessionScope.passwordError}</div>
						<label>请输入邮箱号码发送验证码到邮箱:</label> <img src="ValidateCodeServlet"
							id="validateCode" title="单击换一换" onclick="changeValidateCode()" />
						<input type="text" name="postbox" id="postbox"
							class="input-xlarge"> <select name="to2" id="to2"
							class="input-xlarge">

							<option value="@qq.com" name="to2" id="to2">@qq.com</option>
							<option value="@163.com" name="to2" id="to2">@163.com</option>
							<option value="@163.net" name="to2" id="to2">@163.net</option>
							<option value="@263.net" name="to2" id="to2">@263.net</option>

						</select> <a href="javascript:postbox();" onclick="changeValidateCode()">点击发送邮件获取验证码</a>
						<label>请输入验证码:</label> <input type="text" name="validateCode"
							id="validateCode1" class="input-xlarge">
						<div class=" alert-danger">${sessionScope.validateCodeError}</div>
						<br> <input class="btn btn-primary" type="submit" value="注册"
							onclick="a()" />
						<%
					
				%>
					</form>
				</div>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">Delete Confirmation</h3>
					</div>
					<div class="modal-body">

						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>Are you sure you want
							to delete the user?
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
						<button class="btn btn-danger" data-dismiss="modal">Delete</button>
					</div>
				</div>



				<footer>
				<hr>
				<p class="pull-right">
					Collect from <a href="http://www.cssmoban.com/" title="网页模板"
						target="_blank">网页模板</a>
				</p>
				<p>
					&copy; 2019 <a href="#" target="_blank">Portnine</a>
				</p>
				</footer>

			</div>
		</div>
	</div>

	<%
		session.removeAttribute("validateCodeError");
		session.removeAttribute("usernameError");
		session.removeAttribute("passwordError");
	%>

	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        function a(){
        	var username = document.getElementById("username").value;
        	var password = document.getElementById("password").value;
        	var password1 = document.getElementById("password1").value;
        	var validateCode1 = document.getElementById("validateCode1").value;
        	var validateCode = document.getElementById("validateCode").src;
        	
        	if(username==""){
        		alert("注册失败！")
        	}else if(password!=password1){
        		alert("注册失败！");
        	}else if(validateCode!=validateCode){
        		alert("注册失败！");
        	}else{
        		alert(" 注册成功！！");
        	}
        	
        }
    </script>

</body>
</html>