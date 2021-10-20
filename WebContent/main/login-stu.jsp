<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String contextPath = request.getContextPath();
%>

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
	href="../lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
<link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">

<script src="../lib/jquery-1.7.2.min.js" type="main/text/javascript"></script>

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

body {
	background-image: url(../images/bg4.jpg);
}

.headeree {
	background-color: transparent;
	margin-top: 50px;
}

.well {
	background-color: rgba(10%, 20%, 30%, 0.2);
	border-radius: 15px;
	margin: 30px;
	padding-left: 360px;
	color: white;
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

				<div class="headeree">
					<center>
						<h1 class="page-title" align="center">学生查找</h1>
					</center>

				</div>
				<!--
		<div class="btn-toolbar">
			<button class="btn btn-primary"><i class="icon-save"></i> Save</button>
			<a href="#myModal" data-toggle="modal" class="btn">Delete</a>
		</div>
		-->
<!--
				<div class="well">
					<form method="post" action="<%=contextPath %>/Loginstu">
						<label>学生学号</label> <input type="text" name="id"
							class="input-xlarge">
						<div class=" alert-danger">${sessionScope.idError}</div>
						<label>学生名称</label> <input type="text" name="name"
							class="input-xlarge">
						<div class=" alert-danger">${sessionScope.nameError}</div>
						<br> <input class="btn btn-primary" type="submit" value="查找" />

					</form>
				</div>
-->

				<div class="well">
					<form method="post" action="<%=contextPath %>/StudentSearch">
						<select name="option" id="DropDownTimezone"
							class="input-xlarge">
							<option value="1" name="myclass">按学号查询</option>
							<option value="2" name="myclass">按姓名查询</option>
							<option value="3" name="myclass">按班级查询</option>
							
						</select>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>查询条件</label> <input type="text" name="str"
							class="input-xlarge">
						
						<div class=" alert-danger">${sessionScope.Error}</div><br>
						<br> <input class="btn btn-primary" type="submit" value="查找" />

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
		
		session.removeAttribute("Error");
	%>


	<script src="../lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>

</body>
</html>