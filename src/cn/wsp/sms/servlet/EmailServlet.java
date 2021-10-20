package cn.wsp.sms.servlet;

import java.io.IOException;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String validateCode1 = (String)session.getAttribute("validateCode");
		
		String postbox = request.getParameter("postbox");
		String to2 = request.getParameter("to2");
		System.out.println(validateCode1);
		
	
		
		System.out.println("!!!!");
		
	String qm ="diovuzofcsihbcah"; //����QQ���䰲ȫ��Ȩ��
	String tu = "qq.com"; //������ĺ�׺����
	//String tto1 ="@qq.com";
	String tto1 =to2;
	String tto =postbox+""+tto1;
	 //�����ʼ�������
	String ttitle="����Ժ�Ƽ�����֤�룬����й¶��֤��������ˣ���������˲����������";

	//String tcontent="���Ļ�Ա:zcdnsz ��� haokongjian ��mysql ���ݿ�,�����Ѿ����޸�Ϊ:123456 ���м�! ������ip:127.0.0.1 ,�粻�������˲���˵�����������Ѿ�й©,��������������ϵ! ! ";
	Properties props=new Properties();
	props.put("mail.smtp.host","smtp."+tu);//���ŵ���������������д�������ǹ�˾�����������Բ����޸ģ�
	props.put("mail.smtp.auth","true");
	Session s=Session.getInstance(props);
	s.setDebug(true);
	MimeMessage message=new MimeMessage(s);
	//����Ϣ�������÷�����/�ռ���/����/����ʱ��
	InternetAddress from = null;
	try {
		from = new InternetAddress("1067228047@"+tu);
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //�����115798090 ��Ϊ�����ŵ�QQ��
	try {
		message.setFrom(from);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	InternetAddress to = null;
	try {
		to = new InternetAddress(tto);
	} catch (AddressException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		message.setRecipient(Message.RecipientType.TO,to);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		message.setSubject(ttitle);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		message.setSentDate(new Date());
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//����Ϣ������������
	BodyPart mdp=new MimeBodyPart();//�½�һ������ż����ݵ�BodyPart����
	try {
		mdp.setContent(validateCode1,"text/html;charset=gb2312");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//��BodyPart�����������ݺ͸�ʽ/���뷽ʽ
	Multipart mm=new MimeMultipart();//�½�һ��MimeMultipart�����������BodyPart��
	//��(��ʵ�Ͽ��Դ�Ŷ��)
	try {
		mm.addBodyPart(mdp);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//��BodyPart���뵽MimeMultipart������(���Լ�����BodyPart)
	try {
		message.setContent(mm);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//��mm��Ϊ��Ϣ���������
	try {
		message.saveChanges();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Transport transport = null;
	try {
		transport = s.getTransport("smtp");
	} catch (NoSuchProviderException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		transport.connect("smtp."+tu,"1067228047",qm);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //�����ҲҪ�޸�Ϊ����QQ����
	try {
		transport.sendMessage(message,message.getAllRecipients());
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		transport.close();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	response.sendRedirect("add_user.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
}
