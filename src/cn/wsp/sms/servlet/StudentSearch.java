package cn.wsp.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;

@WebServlet("/StudentSearch")
public class StudentSearch extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求参数的字符编码
				request.setCharacterEncoding("utf8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				//接收参数
				
				//int id=Integer.parseInt(sid);
				int id;
			
				
				
				String option = request.getParameter("option");
				String  str =  request.getParameter("str");
				
				String loginErrorMsg = "";
				HttpSession session = request.getSession();
				
				if(str.equals("")) {
					loginErrorMsg="请输入信息查找学生！";
					session.setAttribute( "Error", loginErrorMsg);
					

					response.sendRedirect("./main/login-stu.jsp");
					
					return;
				}
				
				//借助Dao完成数据查询
				IStudentDao studentDao = new StudentDaoJDBCImpl();
				
				if(option.equals("")) {
					
					loginErrorMsg="请输入正确信息查找学生！";
					session.setAttribute( "Error", loginErrorMsg);
					

					response.sendRedirect("./main/login-stu.jsp");
					
					return;
				}else if(option.equals("1")) {
					if(str.matches("^[0-9]{1,4}$")) {
						id=Integer.parseInt(str);
						
						
						List<Student> list=null;
						list=studentDao.findlikid(id);
						//System.out.print(student);
						
						
						//具体的登录逻辑业务处理
						
						if(list==null){
							loginErrorMsg = str+"学号不存在，请重新输入！";
							session.setAttribute( "Error", loginErrorMsg);
							
							response.sendRedirect("./main/login-stu.jsp");
							
							return;
						}
						
						session.setAttribute("list", list);
						response.sendRedirect("./main/student.jsp");
						
					}else {
						out.flush();
						
						out.print("<script type='text/javascript'>");
						out.print("alert('注意查找类型格式！');");
						out.print("parent.location.reload();");
						out.print("</script>");
						out.close();
						
						
					}
					
					
					
				}else if(option.equals("2")){
					List<Student> list=null;
					list=studentDao.findlikename(str);
					if(list==null) {
						loginErrorMsg = str+"学生不存在，请重新输入！";
						session.setAttribute( "Error", loginErrorMsg);
						
					
						response.sendRedirect("./main/login-stu.jsp");
						
						return;
					}
					
					session.setAttribute("list", list);
					response.sendRedirect("./main/student.jsp");
				}else if(option.equals("3")) {
					List<Student> list=null;
					list=studentDao.findlikclass(str);
					
					
					
					if(list==null) {
						loginErrorMsg = str+"该班级学生不存在，请重新输入！";
						session.setAttribute( "Error", loginErrorMsg);
						
						
						response.sendRedirect("./main/login-stu.jsp");
						
						return;
					}
					session.setAttribute("list", list);
					response.sendRedirect("./main/student.jsp");
				}else {
					
				}
				
				
				
			
				
				
				
				
			/*	
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
				
				*/
	}
}
