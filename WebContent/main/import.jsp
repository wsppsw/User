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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="../lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
<link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">

<script src="../lib/jquery-1.7.2.min.js" type="text/javascript"></script>

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

.block {
	margin-top: 50px;
	background-color: rgba(10%, 20%, 30%, 0.3);
	border-radius: 15px;
	color: white;
}

.block-heading11 {
	background-color: transparent;
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
<body class="">


	<div class="row-fluid">

		<div class="dialog">
			<center>
				<h2 class="block-heading11">请上传与模板格式相同的Excel文件</h2>
			</center>
			<div class="block">

				<div class="block-body">
					<form action="<%=contextPath %>/import" method="post"
						enctype="multipart/form-data">
						<label>上传学生信息</label><input name="dataFile" type="file"
							value="上传Excel数据" class="span12"></input> <input name="submit"
							type="submit" value="上传" class="btn btn-primary pull-right">
						<div class="clearfix"></div>
					</form>
				</div>
			</div>
			<a href="<%=contextPath %>/template/dataTemplate.xls" style="color: #FF6600;">没有模板？点击这里下载</a><br>
			<br>

		</div>
	</div>





	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>

</body>
</html>