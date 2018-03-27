package com.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter  {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//获取参数
				String name = req.getParameter("name");
				System.out.println(name);
				String possword = req.getParameter("possword");
				System.out.println(possword);
				if ("zhangsan".equals(name) && "123".equals(possword)) {
					//登录成功
					//创建对象
					HttpSession session =  null;
					//把数据保存到域对象中
					session.setAttribute("name",name);
					//跳转到列表页面
				}else{
					//登录失败的情况
				}
	}

	@Override
	public void destroy() {
		
	}

}
