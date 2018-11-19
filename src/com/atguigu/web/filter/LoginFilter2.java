package com.atguigu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter2 implements Filter {

  
    public LoginFilter2() {
       System.out.println("LoginFilter2 创建！");
    }

	
	public void destroy() {
		System.out.println("LoginFilter2 destroy！");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("LoginFilter2 doFilter！");
		// 必须要执行，放行！放行到下一个Filter或者是目标资源
		chain.doFilter(request, response);
		
		System.out.println("LoginFilter2 后续代码！");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoginFilter init！");
	}

}
