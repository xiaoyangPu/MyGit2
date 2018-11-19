package com.atguigu.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CookieServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 在接受到请求时，在服务端创建cookie
		Cookie cookie = new Cookie("username", "tom");
		
		// 获取当前项目所在的绝对路径，一直到项目名
		String path = request.getContextPath();
		
		System.out.println(path);
		// 设置当前cookie的访问路径，只有访问以下路径，才会携带此cookie
		cookie.setPath(path+"/hello");
		
		// 将cookie加入到响应中，返回给浏览器
		response.addCookie(cookie);
		
		response.getWriter().print("success!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
