package cn.wsp.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;

@WebServlet("/Loginstu")
public class Loginstu extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置请求参数的字符编码
		request.setCharacterEncoding("utf8");
		//接收参数
		String  sid =  request.getParameter("id");
		int id=Integer.parseInt(sid);
		System.out.println(sid);
		String name = request.getParameter("name");
		
		
		
		String loginErrorMsg = "";
		HttpSession session = request.getSession();
		
		
		
		
		
		
		//借助Dao完成数据查询
		IStudentDao studentDao = new StudentDaoJDBCImpl();
		Student student = studentDao.findById(id);
		System.out.print(student);
		String idd=String.valueOf( student.getId());
		
		
		//具体的登录逻辑业务处理
		
		if(sid==null){
			loginErrorMsg = sid+"学号不存在，请重新输入！";
			session.setAttribute( "idError", loginErrorMsg);
			
			
			session.removeAttribute("nameError");
			
			response.sendRedirect("./main/login-stu.jsp");
			
			return;
		}
		
		if(!student.getName().equals(name)){
			loginErrorMsg = "无该学生，请重新输入！";
			session.setAttribute("nameError", loginErrorMsg);
			
			
			session.removeAttribute("idError");
			
			response.sendRedirect("./main/login-stu.jsp");
			
			return;
		}
		
		
		//如果前面的if判断都不成立，则说明登录信息正确
		//此时，要把登录的用户对象放到session中
		session.setAttribute("student", student);
		
		response.sendRedirect("./main/student.jsp");
		
	
		
		
	}
}
