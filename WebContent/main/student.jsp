<%@page import="cn.wsp.sms.util.PageBean"%>
<%@page import="cn.wsp.sms.domain.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
	//Student stu = (Student)session.getAttribute("student");
	List<Student> list = (List<Student>)session.getAttribute("list");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap Admin</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/stylesheets/theme.css">
<link rel="stylesheet"
	href="<%=contextPath %>/lib/font-awesome/css/font-awesome.css">

<script src="<%=contextPath %>/lib/jquery-1.7.2.min.js"
	type="text/javascript"></script>

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
.well {
	background-color: rgba(10%, 20%, 30%, 0.2);
	border-radius: 15px;
}
thead {
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

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body >
	<!--<![endif]-->


	


	<div>

		<div class="header">

			<center>
				<h1 class="page-title">学生信息</h1>
			</center>
		</div>


		<div class="container-fluid">
			<div class="row-fluid">

				<div class="btn-toolbar">
					<!--  <a href="<%=contextPath %>/main/stu_add.jsp" target="content">
							    <button href="<%=contextPath %>/main/stu_add.jsp" target="content" class="btn btn-primary"><i class="icon-plus"></i> 添加学生</button>
							    </a>
							    <button class="btn">导入数据</button>
							    <button class="btn">导出数据</button> -->
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>班级</th>
								<th>分数</th>

							</tr>
						</thead>
						<tbody>
							
							
							<%
								
									for(Student student:list){
								%>

							<tr>

								<td style="color: #FF6600;"><%=student.getId() %></td>
								<td style="color: #FF6600;"><%=student.getName() %></td>
								<td style="color: #FF6600;"><%=student.getMyclass() %></td>
								<td style="color: #FF6600;"><%=student.getScore() %></td>

							</tr>
								<%}
									
									%>
								
								

						</tbody>
					</table>
				</div>


				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">删除提示</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>确定要删除该信息?
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>


						<button class="btn btn-danger" data-dismiss="modal">确定</button>

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



	<script src="<%=contextPath %>/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>

</body>
</html>


