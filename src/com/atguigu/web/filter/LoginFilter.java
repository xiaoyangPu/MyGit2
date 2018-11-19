package com.atguigu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

  
    public LoginFilter() {
       System.out.println("LoginFilter 创建！");
    }

	
	public void destroy() {
		System.out.println("LoginFilter destroy！");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) request;
		
		HttpServletResponse resp=(HttpServletResponse) response;
		
		if (req.getRequestURI().contains("list.jsp")) {
			
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
			
		}else {
			// 必须要执行，放行！放行到下一个Filter或者是目标资源
			chain.doFilter(request, response);
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoginFilter init！");
	}

}
