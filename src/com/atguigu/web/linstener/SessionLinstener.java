package com.atguigu.web.linstener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionLinstener implements HttpSessionListener {

 
    public SessionLinstener() {
       System.out.println("SessionLinstener 已经创建！");
    }

	
    public void sessionCreated(HttpSessionEvent se)  { 
       // 获取代表当前web应用的ServletContext对象
    	ServletContext application = se.getSession().getServletContext();
    	
    	Integer count = (Integer) application.getAttribute("count");
    	
    	if (count == null) {
			application.setAttribute("count", 1);
		}else {
			// 自增1
			count++;
			application.setAttribute("count", count);
			
		}
    	
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         
    	ServletContext application = se.getSession().getServletContext();
    	
    	Integer count = (Integer) application.getAttribute("count");
    	
    	 count--;
    	
    	application.setAttribute("count", count);
    	
    }
	
}
