<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生信息管理后台</title>

</head>


<frameset rows="35px,*" border="1" framespacing="0">
	<frame name="top" src="top.jsp" scrolling="no" />


	<frameset cols="200px,*" border="1" framespacing="0">
		<frame name="menu" src="menu.jsp" scrolling="no" />
		<frame name="content" src="content.jsp" />
	</frameset>
</frameset>
<noframes></noframes>
</html>
<!--
	rows表示 ，"行分割”，上下分割，分割的是高度。
	cols表示，"列分割"，左右分割，分割的是宽度。
	* 表示分割后剩余的空间。
	framespacing表示的是框架于框架直接分割的距离
	bordercolor表示的是边框的颜色
	frameboreder表示的是框架的边框
	scrolling表示是否显示卷轴
-->