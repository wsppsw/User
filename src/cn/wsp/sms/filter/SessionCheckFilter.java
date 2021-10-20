package cn.wsp.sms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wsp.sms.domain.User;



public class SessionCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//把一般的请求对象request强转成HttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		
		//获得当前会话对象
		HttpSession session = req.getSession();
		
		User loginUser = (User)session.getAttribute("loginUser");
		
		
		if(loginUser == null){
			session.setAttribute("loginError", "登录信息有误，请登录后再访问！");
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect("../login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
