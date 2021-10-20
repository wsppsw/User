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
		
		//��������������ַ�����
		request.setCharacterEncoding("utf8");
		//���ղ���
		String  sid =  request.getParameter("id");
		int id=Integer.parseInt(sid);
		System.out.println(sid);
		String name = request.getParameter("name");
		
		
		
		String loginErrorMsg = "";
		HttpSession session = request.getSession();
		
		
		
		
		
		
		//����Dao������ݲ�ѯ
		IStudentDao studentDao = new StudentDaoJDBCImpl();
		Student student = studentDao.findById(id);
		System.out.print(student);
		String idd=String.valueOf( student.getId());
		
		
		//����ĵ�¼�߼�ҵ����
		
		if(sid==null){
			loginErrorMsg = sid+"ѧ�Ų����ڣ����������룡";
			session.setAttribute( "idError", loginErrorMsg);
			
			
			session.removeAttribute("nameError");
			
			response.sendRedirect("./main/login-stu.jsp");
			
			return;
		}
		
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
		
	
		
		
	}
}
