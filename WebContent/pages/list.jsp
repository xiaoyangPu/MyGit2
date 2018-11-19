<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
 <%@page import="com.atguigu.web.bean.Employee"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1 align="center">欢迎${isLogin }登录,当前在线${count }人</h1>
		<table align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFF00" style="text-align:center">  
 			 <tr bgcolor="#FFFF00">  
     			<td>ID</td>  
      			<td>LASTNAME</td>  
      			<td>GENDER</td> 
      			<td>EMAIL</td> 
 			 </tr>  
		<%-- <% List<Employee> emps=(List<Employee>)request.getAttribute("emps");
			
			for(Employee emp: emps){
				%>
			<tr bgcolor="#FFFF00">  
     			<td><%=emp.getId() %></td>  
      			<td><%=emp.getLastName() %></td>  
      			<td><%=emp.getGender() %></td> 
      			<td><%=emp.getEmail() %></td> 
 			</tr>  
				
		<%
			}
		%> --%>
			<!-- 遍历一个集合
				items": 要遍历的集合
				var： 代表集合中的一个元素的形参
			 -->
			<c:forEach items="${emps }" var="emp"> 
				<tr bgcolor="#FFFF00">  
	     			<td>${emp.id }</td>  
	      			<td>${emp.lastName }</td>  
	      			<td>${emp.gender }</td> 
	      			<td>${emp.email }</td> 
	 			</tr>  
			</c:forEach>
		</table>  
		

</body>
</html>