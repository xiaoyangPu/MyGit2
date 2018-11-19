package com.atguigu.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFirstServlet implements Servlet{
	
	public MyFirstServlet() {
		System.out.println("MyFirstServlet 被创建了！");
	}

	// 当前MyFirstServlet初始化时调用！
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyFirstServlet init()!");
		
	}

	// 可以获取到servlet的配置信息
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	//  处理请求，完成响应！ 对外提供服务的方法！
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println(" 处理了当前请求！");
		
	}

	// 可以返回当前servlet的说明信息
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	// 销毁方法
	@Override
	public void destroy() {
		System.out.println("MyFirstServlet destory()!");
		
	}

}
