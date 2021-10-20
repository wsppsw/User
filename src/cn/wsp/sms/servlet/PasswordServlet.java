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
import cn.wsp.sms.dao.IUserDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.dao.impl.UserDaoJdbcImpl;
import cn.wsp.sms.domain.Student;
import cn.wsp.sms.domain.User;

@WebServlet("/PasswordServlet")
public class PasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ��ñ�����
		//		request.setCharacterEncoding("utf8");
				
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				
				String username =request.getParameter("username");
				String oldpassword =request.getParameter("oldpassword");
				String newpassword1 =request.getParameter("newpassword1");
				String newpassword2 =request.getParameter("newpassword2");
				
				IUserDao userDao = new UserDaoJdbcImpl();
				User user = userDao.findByName(username);
				
				HttpSession session = request.getSession();
				String loginErrorMsg = "";
				//User user = new User();
				
				
				
				System.out.print(user);
				if(!user.getPassword().equals(oldpassword)){
					loginErrorMsg = "ԭ�������";
					session.setAttribute("oldpasswordError", loginErrorMsg);
					
					session.removeAttribute("newpassword1Error");
				
					
					System.out.println("ԭ�������");
					
					response.sendRedirect("./main/password_modify.jsp");
					
					return;
				}
				
				
			if(!newpassword1.equals(newpassword2)){
				loginErrorMsg = "�����벻һ�£�";
				
				session.setAttribute("newpassword1Error", loginErrorMsg);
				
				session.removeAttribute("oldpasswordError");
				
				System.out.println("�����벻һ�£�");

				response.sendRedirect("./main/password_modify.jsp");
				return;
			}
			int id =user.getId();
			System.out.println(id);
			
			User users = new User();
			users.setPassword(newpassword1);
			int flag =userDao.modify(id, users);
			System.out.print(flag);
			
			System.out.println("success!");
			
			 out.flush();
			
			out.print("<script type='text/javascript'>");
			out.print("alert('�޸�����ɹ���');");
			out.print("parent.location.reload();");
			out.print("</script>");
			out.close();
			//response.sendRedirect("./main/content.jsp");
	}
}
