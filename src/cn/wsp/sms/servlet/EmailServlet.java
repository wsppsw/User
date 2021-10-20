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
		
	String qm ="diovuzofcsihbcah"; //您的QQ邮箱安全授权码
	String tu = "qq.com"; //你邮箱的后缀域名
	//String tto1 ="@qq.com";
	String tto1 =to2;
	String tto =postbox+""+tto1;
	 //接收邮件的邮箱
	String ttitle="【民院科技】验证码，请勿泄露验证码给其他人；如非您本人操作，请忽略";

	//String tcontent="您的会员:zcdnsz 里的 haokongjian 的mysql 数据库,密码已经被修改为:123456 请切记! 操作人ip:127.0.0.1 ,如不是您本人操作说明您的密码已经泄漏,请立即和我们联系! ! ";
	Properties props=new Properties();
	props.put("mail.smtp.host","smtp."+tu);//发信的主机，这里我填写的是我们公司的主机！可以不用修改！
	props.put("mail.smtp.auth","true");
	Session s=Session.getInstance(props);
	s.setDebug(true);
	MimeMessage message=new MimeMessage(s);
	//给消息对象设置发件人/收件人/主题/发信时间
	InternetAddress from = null;
	try {
		from = new InternetAddress("1067228047@"+tu);
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //这里的115798090 改为您发信的QQ号
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
	//给消息对象设置内容
	BodyPart mdp=new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
	try {
		mdp.setContent(validateCode1,"text/html;charset=gb2312");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//给BodyPart对象设置内容和格式/编码方式
	Multipart mm=new MimeMultipart();//新建一个MimeMultipart对象用来存放BodyPart对
	//象(事实上可以存放多个)
	try {
		mm.addBodyPart(mdp);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
	try {
		message.setContent(mm);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//把mm作为消息对象的内容
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
	} //这里的也要修改为您的QQ号码
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
