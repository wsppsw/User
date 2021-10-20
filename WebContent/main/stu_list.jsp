<%@page import="cn.wsp.sms.util.PageBean"%>
<%@page import="cn.wsp.sms.domain.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	
	String contextPath = request.getContextPath();
	PageBean<Student> pageBean = (PageBean<Student>)request.getAttribute("pageBean");
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
	background-image: url(images/bg4.jpg);
}

.btn-toolbar {
	background-color: rgba(10%, 20%, 30%, 0.1);
	background-color: transparent;
}

.well {
	background-color: rgba(10%, 20%, 30%, 0.2);
	border-radius: 15px;
}

.headeree {
	background-color: transparent;
	margin-top: 30px;
}

thead {
	color: white;
}

.icon-pencil .icon-remove {
	color: white;
}

i {
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
<body class="">
	<!--<![endif]-->





	<div>




		<div class="container-fluid">

			<div class="headeree">

				<center>
					<h1 class="page-title">学生列表</h1>
				</center>
			</div>
			<div class="row-fluid">

				<div class="btn-toolbar">
					<a href="<%=contextPath %>/main/stu_add.jsp" target="content">
						<button href="<%=contextPath %>/main/stu_add.jsp" target="content"
							class="btn btn-primary">
							<i class="icon-plus"></i> 添加学生
						</button>
					</a> <a href="<%=contextPath %>/main/import.jsp">
						<button class="btn">导入数据</button>
					</a> <a href="<%=contextPath %>/exportData">
						<button class="btn">导出数据</button>
					</a><a href="<%=contextPath %>/main/login-stu.jsp" target="content">
						<button href="<%=contextPath %>/main/login-stu.jsp" target="content"
							class="btn btn-primary">
							<i class="icon-plus"></i> 查询学生
						</button>
					</a> 
					
					<!--  <a href="#myModal" role="button" data-toggle="modal">
							    <button class="btn">前10名</button>
							    </a>
							     -->
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
								<th>操作</th>
							</tr>
						</thead>

						<tbody>

							<%
							       	    double aa=0.01,bb=0.01,cc=0.01,dd=0.01;
							        	for(Student stu:pageBean.getList()){
							        		
							        		
							        %>

							<tr>

								<%
							          	if(stu.getScore()>=90){
							          		
							          		aa=aa+1;
							          %>
								<td style="color: #FF6600;"><%=stu.getId() %></td>
								<td style="color: #FF6600;"><%=stu.getName() %></td>
								<td style="color: #FF6600;"><%=stu.getMyclass() %></td>
								<td style="color: #FF6600;"><%=stu.getScore() %></td>
								<%
							        	}else if(stu.getScore()<90&&stu.getScore()>=80){
							        		bb=bb+1;
							          %>

								<td style="color: yellow;"><%=stu.getId() %></td>
								<td style="color: yellow;"><%=stu.getName() %></td>
								<td style="color: yellow;"><%=stu.getMyclass() %></td>
								<td style="color: yellow;"><%=stu.getScore() %></td>
								<%
							        	}else if(stu.getScore()<80&&stu.getScore()>=60){
							        		cc=cc+1;
							          %>
								<td style="color: pink;"><%=stu.getId() %></td>
								<td style="color: pink;"><%=stu.getName() %></td>
								<td style="color: pink;"><%=stu.getMyclass() %></td>
								<td style="color: pink;"><%=stu.getScore() %></td>
								<%
							        	}else{
							        		dd=dd+1;
							          %>
								<td style="color: red;"><%=stu.getId() %></td>
								<td style="color: red;"><%=stu.getName() %></td>
								<td style="color: red;"><%=stu.getMyclass() %></td>
								<td style="color: red;"><%=stu.getScore() %></td>
								<%
							        	}
							          %>
								<td><a
									href="<%=contextPath%>/main/stu_modify.jsp?id=<%=stu.getId()%>"><i
										class="icon-pencil"></i></a> <a
									href="<%=contextPath%>/stu_delete?id=<%=stu.getId()%>"
									onClick="return confirm('真的要删除该学生吗?')"><i
										class="icon-remove"></i></a></td>
							</tr>

							<%
							        	}//for 语句的结束
							        	
							        	
							        %>

						</tbody>
					</table>
				</div>
				<div class="pagination" align="center">
					<ul>
						<li><a>共<%=pageBean.getPageCount() %>页
						</a></li>

						<li><a>当前页：<%=pageBean.getPageIndex() %></a></li>

						<%-- 如果当前页是第1页，则“上一页”不可用 --%>
						<%
							    		if(pageBean.getPageIndex() == 1){
							    	%>
						<li><a>首页</a></li>
						<%
							    		}else{
							    	%>
						<li><a
							href="<%=contextPath%>/stu_list?pageIndex=<%=pageBean.getPageIndex()-1 %>">上一页</a></li>
						<%
							    		}
							        %>


						<%-- 生成所有页号 --%>
						<%
							        	for(int i = 1; i <= pageBean.getPageCount();i++ ){
							        %>
						<li><a href="<%=contextPath%>/stu_list?pageIndex=<%= i %>"><%=i %></a></li>
						<% 	
							        	} 
							        %>


						<%-- 如果当前页是最后1页，则“下一页”不可用 --%>
						<%
							    		if(pageBean.getPageIndex() == pageBean.getPageCount()){
							    	%>
						<li><a>尾页</a></li>
						<%
							    		}else{
							    	%>
						<li><a
							href="<%=contextPath%>/stu_list?pageIndex=<%=pageBean.getPageIndex()+1 %>">下一页</a></li>


						<%
							    		}
							        %>
						 <li>
							        <a href="<%=contextPath %>/main/chat.jsp?aa=<%=aa%>&bb=<%=bb%>&cc=<%=cc%>&dd=<%=dd%>" id="lai">
								    <button class="btn" >统计数据</button>
								    </a></li>
							 
						<%
							        	System.out.print(aa+",");
								        System.out.print(bb+",");
								        System.out.print(cc+",");
								        System.out.println(dd);
								        
							        %>
					<!--  
						<form action="<%=contextPath %>/main/chat.jsp">
							<input type="text" style="display: none;" name="aa" id="aa"
								value="<%=aa%>"> <input type="text"
								style="display: none;" name="bb" id="bb" value="<%=bb%>">
							<input type="text" style="display: none;" name="cc" id="cc"
								value="<%=cc%>"> <input type="text"
								style="display: none;" name="dd" id="dd" value="<%=dd%>">
							<input type="submit" id="qqq" value="统计数据">
						</form>
					-->
					</ul>
				</div>


				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">删除提示</h3>
					</div>
					<div class="modal-body">
						<!--    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确定要删除该信息?</p> -->
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
        
        
        var aa = document.getElementById("aa").value;
    	var bb = document.getElementById("bb").value;
    	var cc = document.getElementById("cc").value;
    	var dd = document.getElementById("dd").value;
    	
    	
    	
    	function aaa(){
    		
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
    		
    		
    		var url = "../main/chat.jsp?aa="+aa+"&bb="+bb+"&cc="+cc+"&dd="+dd;
    	
    		xhr.open("POST",url,true);
    		
    		xhr.onreadystatechange = function(){
    			if(xhr.readyState == 4 && xhr.status == 200){

    				alert("发送数据");
    				
    			}
    		}
    		xhr.send();
    	}
    	
    	
    	
    	
    </script>

</body>
</html>


