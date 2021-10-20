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
		//��������������ַ�����
				request.setCharacterEncoding("utf8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				//���ղ���
				
				//int id=Integer.parseInt(sid);
				int id;
			
				
				
				String option = request.getParameter("option");
				String  str =  request.getParameter("str");
				
				String loginErrorMsg = "";
				HttpSession session = request.getSession();
				
				if(str.equals("")) {
					loginErrorMsg="��������Ϣ����ѧ����";
					session.setAttribute( "Error", loginErrorMsg);
					

					response.sendRedirect("./main/login-stu.jsp");
					
					return;
				}
				
				//����Dao������ݲ�ѯ
				IStudentDao studentDao = new StudentDaoJDBCImpl();
				
				if(option.equals("")) {
					
					loginErrorMsg="��������ȷ��Ϣ����ѧ����";
					session.setAttribute( "Error", loginErrorMsg);
					

					response.sendRedirect("./main/login-stu.jsp");
					
					return;
				}else if(option.equals("1")) {
					if(str.matches("^[0-9]{1,4}$")) {
						id=Integer.parseInt(str);
						
						
						List<Student> list=null;
						list=studentDao.findlikid(id);
						//System.out.print(student);
						
						
						//����ĵ�¼�߼�ҵ����
						
						if(list==null){
							loginErrorMsg = str+"ѧ�Ų����ڣ����������룡";
							session.setAttribute( "Error", loginErrorMsg);
							
							response.sendRedirect("./main/login-stu.jsp");
							
							return;
						}
						
						session.setAttribute("list", list);
						response.sendRedirect("./main/student.jsp");
						
					}else {
						out.flush();
						
						out.print("<script type='text/javascript'>");
						out.print("alert('ע��������͸�ʽ��');");
						out.print("parent.location.reload();");
						out.print("</script>");
						out.close();
						
						
					}
					
					
					
				}else if(option.equals("2")){
					List<Student> list=null;
					list=studentDao.findlikename(str);
					if(list==null) {
						loginErrorMsg = str+"ѧ�������ڣ����������룡";
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
						loginErrorMsg = str+"�ð༶ѧ�������ڣ����������룡";
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
					loginErrorMsg = "�޸�ѧ�������������룡";
					session.setAttribute("nameError", loginErrorMsg);
					
					
					session.removeAttribute("idError");
					
					response.sendRedirect("./main/login-stu.jsp");
					
					return;
				}
				
				
				//���ǰ���if�ж϶�����������˵����¼��Ϣ��ȷ
				//��ʱ��Ҫ�ѵ�¼���û�����ŵ�session��
				session.setAttribute("student", student);
				
				response.sendRedirect("./main/student.jsp");
				
				*/
	}
}
