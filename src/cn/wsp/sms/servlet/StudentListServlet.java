package cn.wsp.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;
import cn.wsp.sms.domain.User;
import cn.wsp.sms.util.PageBean;

@WebServlet("/stu_list")
public class StudentListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//得到当前页号
				String sPageIndex = request.getParameter("pageIndex");
				if(sPageIndex == null || "".equals(sPageIndex))
					sPageIndex = "1";
				
				int pageIndex = Integer.parseInt(sPageIndex);
				int pageSize = 10;
				int totalCount = 0;
		
				//借助IStudentDao查询出所有学生数据
				IStudentDao studentDao = new StudentDaoJDBCImpl();
				List<Student> stuList = studentDao.findOnePage(pageIndex, pageSize);
				totalCount = studentDao.findTotalCount();
				
				PageBean<Student> pageBean = new PageBean<Student>(pageIndex, totalCount, pageSize, stuList);
				pageBean.init();
		
		request.setAttribute("pageBean", pageBean);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main/stu_list.jsp");
		dispatcher.forward(request, response);
		
	}
}