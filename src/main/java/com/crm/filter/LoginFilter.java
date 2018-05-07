package com.crm.filter;

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

import org.apache.poi.hssf.record.PageBreakRecord.Break;

public class LoginFilter implements Filter  {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		 // 获得在下面代码中要用的request,response,session对象
			 HttpServletRequest servletRequest = (HttpServletRequest) req;
			 HttpServletResponse servletResponse = (HttpServletResponse) resp;
			 HttpSession session = servletRequest.getSession();
		
		        // 获得用户请求的URI
		        String path = servletRequest.getRequestURI();
		         //System.out.println(path);
		         
		         // 从session里取员工工号信息
		         String name = (String) session.getAttribute("name");
		
		        
		         // 登陆页面无需过滤
		         if(path.indexOf("/login.jsp") > -1) {
		             chain.doFilter(servletRequest, servletResponse);
	             return;
		         }
		 
	         // 判断信息,就跳转到登陆页面
		         if (name == null || "".equals(name)) {
		             // 跳转到登陆页面
		        	 servletResponse.sendRedirect(servletRequest.getContextPath() + "/user/login.action");
		             return;
		         } else {
		             // 已经登陆,继续此次请求
		             chain.doFilter(req, resp);
		        }
		 
				
	}

	@Override
	public void destroy() {
		
	}

}
