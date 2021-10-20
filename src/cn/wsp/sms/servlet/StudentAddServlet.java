package cn.wsp.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;

@WebServlet("/stu_add")
public class StudentAddServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//��ñ�����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");
		String sScore = request.getParameter("score");
		
		
		String msg = "";
		if(name.equals("")||myclass.equals("��")||sScore.equals("")) {
			msg="��Ӳ���Ϊ�գ�";
			
			out.flush();
			
			out.print("<script type='text/javascript'>");
			out.print("alert('���ѧ����Ϣ����Ϊ�գ�');");
			out.print("parent.location.reload();");
			out.print("</script>");
			
			out.close();
		}else {
		
		//�ѱ����ݷ�װ��ʵ�����
		Student stu = new Student();
		stu.setName(name);
		stu.setMyclass(myclass);
		double score = Double.parseDouble(sScore);
		stu.setScore(score);
		
		//ͨ��DAO��ʵ�������ӵ�DB��
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int flag = stuDao.add(stu);
		
		
		if(flag == 1)
			msg = "���ѧ����Ϣ�ɹ���";
		else
			msg = "���ѧ����Ϣʧ�ܣ�����ϵ����Ա��";
		
		if(flag ==1){
			
			out.flush();
			
			out.print("<script type='text/javascript'>");
			out.print("alert('���ѧ����Ϣ�ɹ���');");
			out.print("parent.location.reload();");
			out.print("</script>");
			
			out.close();
			
			//response.sendRedirect("./stu_list");
		}
		//���ɽ��ҳ��
	/*	response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.println("<h2>" + msg + "<a href='stu_list'>�������ѧ��ҳ��</a></h2>" );
		
		out.close();
		*/
	}
	}
}
