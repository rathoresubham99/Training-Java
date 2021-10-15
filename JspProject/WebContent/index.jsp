<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jsp demo</title>
</head>
<body>
<%!
int x=10;
boolean authenticate(){
	System.out.println("Authenticating");
	return true;
}


%>
<h1>welcome to demo</h1>
<%
pageContext.setAttribute("General Info", "This webpage shows about the pageContext", PageContext.APPLICATION_SCOPE);
boolean flag=false;
	if(session.getAttribute("isUserLoggenIn")!=null){
      flag=(boolean)session.getAttribute("isUserLoggenIn");
	
if(flag){
Integer hitCount=(Integer) application.getAttribute("hitCount");
//int hitCount=0;
System.out.println("hitCount: "+hitCount);
if(hitCount==null||hitCount==0){
	out.println("Welcome to world of JSP");
	hitCount=1;
	
}
else{
	out.println("Welcome back to world of JSP");
	hitCount++;
		
}

application.setAttribute("hitCount", hitCount);
}
else
	System.out.println("Redirecting to Login page");
	RequestDispatcher rd = request.getRequestDispatcher("login.html");
	rd.forward(request,response);
}
%>

</body>
</html>