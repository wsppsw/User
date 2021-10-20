package cn.wsp.sms.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wsp.sms.dao.IUserDao;
import cn.wsp.sms.dao.impl.UserDaoJdbcImpl;
import cn.wsp.sms.domain.User;



@WebServlet("/user_add")
public class UserAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.������������ı���
		//request.setCharacterEncoding("utf8");
		//2.�õ��������
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String validateCode = request.getParameter("validateCode");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		
		String loginErrorMsg = "";
		HttpSession session = request.getSession();
		String validateCode1 = (String)session.getAttribute("validateCode");
		
		System.out.println(validateCode1);
		/*if(!validateCode1.equals(validateCode)){
			loginErrorMsg = "��֤��������������룡";
			session.setAttribute("validateCodeError", loginErrorMsg);
			
			session.removeAttribute("usernameError");
			session.removeAttribute("passwordError");
			
			response.sendRedirect("add_user.jsp");
			
			return;
		}
		*/
		
		if(username == ""){
			loginErrorMsg = "�û����Ʋ���Ϊ�գ������������û����ƣ�";
			session.setAttribute( "usernameError", loginErrorMsg);
			
			session.removeAttribute("validateCodeError");
			session.removeAttribute("passwordError");
			
			response.sendRedirect("add_user.jsp");
			
			return;
		}
		
		
		if(!password.equals(password1)||password==null||password1==null){
			loginErrorMsg = "�������벻һ�£����������룡";
			session.setAttribute("passwordError", loginErrorMsg);
			
			session.removeAttribute("validateCodeError");
			session.removeAttribute("usernameError");
			
			response.sendRedirect("add_user.jsp");
			
			return;
		}
		
		//3.����ʵ�����
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		
		
		//4.����IStudentDao����Ϣ��ӵ�DB��
		IUserDao userDao = new UserDaoJdbcImpl();
		int i = userDao.add(user);
		
		if(i == 1){
			
			
			response.sendRedirect("login.jsp");
		}
		
		
	}
}
