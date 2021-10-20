package cn.wsp.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;

@WebServlet("/stu_delete")
public class StudentDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得请求参数
		request.setCharacterEncoding("utf8");
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		//借助DAO完成删除操作
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int flag = stuDao.delete(id);
		
		String msg = "";
		if(flag == 1)
			msg = "删除学生信息成功！";
		else
			msg = "删除学生信息失败，请联系管理员！";
		
		if(flag ==1){
			response.sendRedirect("./stu_list");
		}
		
		//生成结果页面
	/*	response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.println("<h2>" + msg + "<a href='stu_list'>返回浏览学生页面</a></h2>" );
		
		out.close();
		
		*/
	}
	
}
