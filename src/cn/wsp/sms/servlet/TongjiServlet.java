package cn.wsp.sms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;
import cn.wsp.sms.util.PageBean;

@WebServlet("/TongjiServlet")
public class TongjiServlet extends HttpServlet {
	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String aa= request.getParameter("aa");
			String bb= request.getParameter("bb");
			String cc= request.getParameter("cc");
			String dd= request.getParameter("dd");
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main/chat.jsp");
			dispatcher.forward(request, response);
			
		}
}
