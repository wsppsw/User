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
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;

@WebServlet("/stu_modify")
public class StudentModifyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ñ�����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String pageIndex = request.getParameter("pageIndex");
		
		String sId = request.getParameter("id");
		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");
		String sScore = request.getParameter("score");

		int id = Integer.parseInt(sId);
		double score = Double.parseDouble(sScore);

		// �ѱ����ݷ�װ��ʵ�����
		Student stu = new Student();
		stu.setName(name);
		stu.setMyclass(myclass);
		stu.setScore(score);

		HttpSession session =  request.getSession();
		session.setAttribute("pageIndex", pageIndex);
		
		// ͨ��DAO��ʵ�������ӵ�DB��
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int flag = stuDao.modify(id, stu);

		String msg = "";
		if (flag == 1)
			msg = "�޸�ѧ����Ϣ�ɹ���";
		else
			msg = "�޸�ѧ����Ϣʧ�ܣ�����ϵ����Ա��";

		if(flag == 1){
					 
			
			out.flush();
			
			out.print("<script type='text/javascript'>");
			out.print("alert('�޸�ѧ���ɹ���');");
			out.print("parent.location.reload();");
			out.print("</script>");
			
		
			
			//response.sendRedirect("./stu_list");
		}
		// ���ɽ��ҳ��
		/*
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();	
		
	
		out.println("<h2>" + msg + "<a href='stu_list'>�������ѧ��ҳ��</a></h2>");
  	
		out.close();
		*/
	}

}
