<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
<style type="text/css">
p{
color:green;
}
h2{color:teal;}
</style>
</head>
<body>
<form action="logout.jsp">
	<input type="submit" value="logout"/>
	</form>
	<form action="index.jsp">
	<input type="submit" value="goto Index"/>
	</form>
	<%
	session.setAttribute("isUserLoggenIn", true);
	String userName=request.getParameter("userName");
	out.println("Hello: "+userName);
	String driverName=application.getInitParameter("databaseName");
	System.out.println("Loading driver:"+driverName);
	Integer hitCount=0;
	if(application.getAttribute("hitCount")!=null)
	 hitCount=(Integer)application.getAttribute("hitCount");
	
	%>
	<p>you are visitor no: <%=hitCount %>
	<h2>Thank you..<%out.println(userName); %></h2>
	


</body>
</html>