package com.atguigu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.web.dao.UserDao;
import com.atguigu.web.dao.UserDaoImpl;


public class ValidUserNameServlet extends HttpServlet {
	
	private UserDao userDao;
	
	private static final long serialVersionUID = 1L;
       
   
    public ValidUserNameServlet() {
       
    	userDao=new UserDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		
		boolean ifExist = userDao.validUserNameExist(username);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		if (ifExist) {
			
			writer.print("您的用户名已经存在");
			
		}else {
			writer.print("您的用户名不存在");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
