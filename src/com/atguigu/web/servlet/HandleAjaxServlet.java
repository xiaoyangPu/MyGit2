package com.atguigu.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.web.bean.Employee;
import com.atguigu.web.dao.UserDao;
import com.atguigu.web.dao.UserDaoImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class HandleAjaxServlet
 */
public class HandleAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleAjaxServlet() {
      
    	userDao=new UserDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Employee> emps = userDao.getAllEmps();
		
		String resultStr = new Gson().toJson(emps);
		
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().print(resultStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
