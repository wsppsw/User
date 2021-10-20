package cn.wsp.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;

@WebServlet("/stu_modify")
public class StudentModifyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得表单数据
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String pageIndex = request.getParameter("pageIndex");
		
		String sId = request.getParameter("id");
		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");
		String sScore = request.getParameter("score");

		int id = Integer.parseInt(sId);
		double score = Double.parseDouble(sScore);

		// 把表单数据封装成实体对象
		Student stu = new Student();
		stu.setName(name);
		stu.setMyclass(myclass);
		stu.setScore(score);

		HttpSession session =  request.getSession();
		session.setAttribute("pageIndex", pageIndex);
		
		// 通过DAO将实体对象添加到DB中
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int flag = stuDao.modify(id, stu);

		String msg = "";
		if (flag == 1)
			msg = "修改学生信息成功！";
		else
			msg = "修改学生信息失败，请联系管理员！";

		if(flag == 1){
					 
			
			out.flush();
			
			out.print("<script type='text/javascript'>");
			out.print("alert('修改学生成功！');");
			out.print("parent.location.reload();");
			out.print("</script>");
			
		
			
			//response.sendRedirect("./stu_list");
		}
		// 生成结果页面
		/*
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();	
		
	
		out.println("<h2>" + msg + "<a href='stu_list'>返回浏览学生页面</a></h2>");
  	
		out.close();
		*/
	}

}
