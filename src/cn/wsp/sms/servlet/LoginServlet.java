package cn.wsp.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wsp.sms.dao.IUserDao;
import cn.wsp.sms.dao.impl.UserDaoJdbcImpl;
import cn.wsp.sms.domain.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//��������������ַ�����
		request.setCharacterEncoding("utf8");
		//���ղ���
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String validateCode = request.getParameter("validateCode");
		String remember = request.getParameter("remember");
		
		
		String loginErrorMsg = "";
		HttpSession session = request.getSession();
		String validateCode1 = (String)session.getAttribute("validateCode");
		
		
		//System.out.print(c[0]+" "+c[1]);
		
		if(!validateCode1.equals(validateCode)){
			loginErrorMsg = "��֤����������µ�¼��";
			session.setAttribute("validateCodeError", loginErrorMsg);
			
			session.removeAttribute("usernameError");
			session.removeAttribute("passwordError");
			
			response.sendRedirect("login.jsp");
			
			return;
		}
		
		
		
		//����Dao������ݲ�ѯ
		IUserDao userDao = new UserDaoJdbcImpl();
		User user = userDao.findByName(username);
		
		
		//����ĵ�¼�߼�ҵ����
		if(user == null){
			loginErrorMsg = username+"�û��������ڣ����������룡";
			session.setAttribute( "usernameError", loginErrorMsg);
			
			session.removeAttribute("validateCodeError");
			session.removeAttribute("passwordError");
			
			response.sendRedirect("login.jsp");
			
			return;
		}
		
		if(!user.getPassword().equals(password)){
			loginErrorMsg = "����������������룡";
			session.setAttribute("passwordError", loginErrorMsg);
			
			session.removeAttribute("validateCodeError");
			session.removeAttribute("usernameError");
			
			response.sendRedirect("login.jsp");
			
			return;
		}
		
		
		
		
		
		//���ǰ���if�ж϶�����������˵����¼��Ϣ��ȷ
		//��ʱ��Ҫ�ѵ�¼���û�����ŵ�session��
		session.setAttribute("loginUser", user);
		remember(remember,username,password,request,response);
		System.out.print("!!!");
		
		//�ض�����ת����̨��ҳmain.jsp
		response.sendRedirect("./main/main.jsp");
		
	}

	private void remember(String remember, String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		
		if("true".equals(remember)){
			Cookie cookie = new Cookie("COOKIE_USERNAME",CookieEncryptTool.encodeBase64(username));
			
			cookie.setPath("/");
			cookie.setMaxAge(3600*24*10);
			response.addCookie(cookie);
			
			cookie = new Cookie("COOKIE_PASSWORD",CookieEncryptTool.encodeBase64(password));
			
			cookie.setPath("/");
			cookie.setMaxAge(3600*24*10);
			response.addCookie(cookie);
			System.out.print(cookie);
		}else{
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie cookie: cookies){
					if("COOKIE_USERNAME".equals(cookie.getName())
							||"COOKIE_PASSWORD".equals(cookie.getName())){
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
	}
}
