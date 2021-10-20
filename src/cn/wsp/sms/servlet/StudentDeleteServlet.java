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
		//����������
		request.setCharacterEncoding("utf8");
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		//����DAO���ɾ������
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int flag = stuDao.delete(id);
		
		String msg = "";
		if(flag == 1)
			msg = "ɾ��ѧ����Ϣ�ɹ���";
		else
			msg = "ɾ��ѧ����Ϣʧ�ܣ�����ϵ����Ա��";
		
		if(flag ==1){
			response.sendRedirect("./stu_list");
		}
		
		//���ɽ��ҳ��
	/*	response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.println("<h2>" + msg + "<a href='stu_list'>�������ѧ��ҳ��</a></h2>" );
		
		out.close();
		
		*/
	}
	
}
