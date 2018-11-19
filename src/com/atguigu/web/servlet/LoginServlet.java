package com.atguigu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.web.bean.Employee;
import com.atguigu.web.bean.User;
import com.atguigu.web.dao.UserDao;
import com.atguigu.web.dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
    public LoginServlet() {
    	userDao=new UserDaoImpl();
    }

    //HttpServletRequest request： 代表请求报文
    // HttpServletResponse response： 代表响应报文
    
    /*
     * 乱码：  
     * 		响应乱码：
     * 			    告诉浏览器，使用UTF-8编码解析响应体中 的内容！
     * 				response.setContentType("text/html;charset=utf-8");
     * 
     * 			前提： 在获取字符流之前设置才有效！
     * 			
     * 		请求乱码：
     * 			  POST请求乱码：
     * 					在服务器端，第一次获取参数之前！设置请求报文的字符集！
     * 				request.setCharacterEncoding("utf-8");
     * 
     * 			  GET请求乱码：
     * 					GET请求，参数是附加在url后面！url首先被tomcat解析！
     * 
     * 				    tomcat 默认使用的是iso-8859-1编码，无法解析中文！
     * 
     * 					设置tomcat的编码为utf-8！
     * 
     * 				在server.xml中，找到<connnector URIEncoding="utf-8" port="8080">
     * 					
     * 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 取出cookie
		Cookie[] cookies = request.getCookies();
		
		if (cookies !=null) {
			
			for (Cookie cookie : cookies) {
				
				System.out.println(cookie.getName()+"===>"+cookie.getValue());
				
			}
			
		}
		
		// 获取当前的session
		HttpSession session = request.getSession();
		
		System.out.println("获取到的session的id"+session.getId());
		
		System.out.println("是否是一个新建的session"+session.isNew());
		
		request.setCharacterEncoding("utf-8");
		
		// 获取html页面表单中的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username+"====>"+password);
		
		User user = userDao.findUserByUsernameAndPassword(username, password);
		
		// 解决响应乱码
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		if (user == null) {
		    // 假如用户非法，希望直接帮助用户跳转到登录页面继续操作	， 使用重定向
			//writer.print("非法的用户！！!");
			// http://localhost:8080/0906_Javaweb/index.html
			
			//response.sendRedirect("/0906_Javaweb/index.html");
			/*
			String errorPage="<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>首页</title></head>\r\n" + 
					"<body bgcolor=\"pink\"><h1>欢迎登录</h1><br/><!-- span 用来定义文章中的节！用来放入文本的一个区域  -->\r\n" + 
					"<form action=\"/0906_Javaweb/hello\" method=\"get\">用户名称 <input name=\"username\" value=\"jack\"/><span>用户名和密码错误</span><br/>用户密码 <input name=\"password\" value=\"123\"/><br/>\r\n" + 
					"<input type=\"submit\" value=\"提交\"/></form></body></html>";
			
			writer.print(errorPage);*/
			
			String errorInfo="用户名非法！请仔细核对！";
			
			request.setAttribute("error", errorInfo);
			
			// 转发操作！ 将当前请求和响应处理完后，再交给下一个servlet继续处理！
			// http://localhost:8080/0906_Javaweb/index.jsp
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
		}else {
			
			// 将用户名作为cookie写回浏览器
			Cookie cookie = new Cookie("username", username);
			
			cookie.setPath(request.getContextPath()+"/index.jsp");
			
			cookie.setMaxAge(60*60*24*7);
			
			response.addCookie(cookie);
			//=================记录用户的登录状态===================
			
			session.setAttribute("isLogin", username);
			
			//==============================
			request.getRequestDispatcher("/queryAllEmps").forward(request, response);
			
		}
		
		
		System.out.println("处理了当前的请求！");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
