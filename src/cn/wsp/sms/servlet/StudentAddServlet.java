package cn.wsp.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;

@WebServlet("/stu_add")
public class StudentAddServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//获得表单数据
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");
		String sScore = request.getParameter("score");
		
		
		String msg = "";
		if(name.equals("")||myclass.equals("无")||sScore.equals("")) {
			msg="添加不得为空！";
			
			out.flush();
			
			out.print("<script type='text/javascript'>");
			out.print("alert('添加学生信息不能为空！');");
			out.print("parent.location.reload();");
			out.print("</script>");
			
			out.close();
		}else {
		
		//把表单数据封装成实体对象
		Student stu = new Student();
		stu.setName(name);
		stu.setMyclass(myclass);
		double score = Double.parseDouble(sScore);
		stu.setScore(score);
		
		//通过DAO将实体对象添加到DB中
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int flag = stuDao.add(stu);
		
		
		if(flag == 1)
			msg = "添加学生信息成功！";
		else
			msg = "添加学生信息失败，请联系管理员！";
		
		if(flag ==1){
			
			out.flush();
			
			out.print("<script type='text/javascript'>");
			out.print("alert('添加学生信息成功！');");
			out.print("parent.location.reload();");
			out.print("</script>");
			
			out.close();
			
			//response.sendRedirect("./stu_list");
		}
		//生成结果页面
	/*	response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.println("<h2>" + msg + "<a href='stu_list'>返回浏览学生页面</a></h2>" );
		
		out.close();
		*/
	}
	}
}
