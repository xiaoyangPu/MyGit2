<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>INDEX2.jsp</h1>
			<% 
				String pageStr=(String)pageContext.getAttribute("page");
				String requestStr=(String)request.getAttribute("request");
				String sessionStr=(String)session.getAttribute("session");
				String applicationStr=(String)application.getAttribute("application");
				
			%>
			

			<%= pageStr %><br>
			<%= requestStr %><br>
			<%= sessionStr %><br>
			<%= applicationStr %><br>
			
</body>
</html>