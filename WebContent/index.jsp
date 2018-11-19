<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/0906_Javaweb/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
		
		function clearSpan(){
			
			// 获取span()
			//var myspan=document.getElementById("errorspan");
			
			//myspan.innerHTML="";
			$("#errorspan").html("");
			
			
		}
		
		// 期望在此函数中通过ajax发送请求，验证用户填写的用户名是否在数据库存在
		function validUsername(){
			
			// 创建XMLHttpRequest
			var xmlhttp=new XMLHttpRequest();
			// 准备发送请求
			
			// 获取用户名输入框的值value属性
			var value=document.getElementById("nameInput").value;
			
			var validUrl="/0906_Javaweb/valid?username="+value;
			
			xmlhttp.open("GET",validUrl,true);
			
			xmlhttp.send();
			
			// 等待接受服务器端的响应，保证在当前响应成功时，responseText 才会正确封装服务器的响应信息
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
				  document.getElementById("errorspan").innerHTML=xmlhttp.responseText;
			    }
			  }


		}
		
		function  jqueryValidUserName(){
			
			// 获取form表单的url属性
			//var url=$("#myForm").attr("action");
			// 获取其中的参数
			var value=$("#nameInput").val();
			
			$.ajax({
				   type: "POST",
				   url: "/0906_Javaweb/valid",
				   data: "username="+value,
				   success: function(msg){
					   $("#errorspan").html(msg);
				   }
				});
			
			
		}
			
				
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
		<!--   
				用户在修改了usernameinput输入框的值后，将错误提示信息消除！
				事件： onchange对比输入框中内容的变化，一旦发生变化，执行onchange对应的函数！
						onchange=function(){
							将span中的内容抹去，赋值为""
							// 在每个标签对象（dom模型）中，都有一个属性为innerHTML,代表标签体中所有内容！
							
						}
				
		 -->
		 
		<c:if test="${empty sessionScope.isLogin }">
			
			<h1>欢迎登录</h1><br/>
			<form id="myForm" action="/0906_Javaweb/hello" method="get">
						用户名称 <input id="nameInput" name="username" value="${cookie.username.value }"  onblur="jqueryValidUserName()"
						onchange="clearSpan()" />
						<span id="errorspan">${error }</span><br/>
						用户密码 <input name="password" value="123456" onchange="clearSpan()"/><br/>
						<input type="submit" value="提交"/>
			</form>
		</c:if>
		
		<c:if test="${! empty sessionScope.isLogin }">
				<a href="queryAllEmps">查看所有的employee</a>
		</c:if>
		

</body>
</html>