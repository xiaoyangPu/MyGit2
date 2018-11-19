<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<h1>hello</h1>
			<% System.out.println("hello"); 
				int i=0;
				
				pageContext.setAttribute("page", "当前页面！");
				request.setAttribute("request", "当前请求！");
				session.setAttribute("session", "当前会话");
				application.setAttribute("application", "当前应用！");
				
				String pageStr=(String)pageContext.getAttribute("page");
				String requestStr=(String)request.getAttribute("request");
				String sessionStr=(String)session.getAttribute("session");
				String applicationStr=(String)application.getAttribute("application");
				
			%>
			
			<%=new Date() %>
			<%= i %><br>
			<%= pageStr %><br>
			<%= requestStr %><br>
			<%= sessionStr %><br>
			<%= applicationStr %><br>
			
			<!-- HTML的注释 -->
			<%--  JSP的注释 --%>

</body>
</html>