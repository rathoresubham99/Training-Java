 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
    <%@page import="java.util.ArrayList, model.Employee,model.Department" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html 4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
Home Page

<%
ArrayList<Employee> empList=null;
if(request.getAttribute("empList")!=null)
empList = (ArrayList<Employee>)request.getAttribute("empList");

Long empCount=(Long)request.getAttribute("empCount");
if(empCount==null)
	empCount=(Long)pageContext.getAttribute("empCount",PageContext.APPLICATION_SCOPE);

int noOfPages =(int) Math.ceil(empCount/10);
int rem=(int)(empCount%10); //56%10=6
System.out.print(noOfPages);
if(rem>0)
	noOfPages++;

boolean isFirstCall=(boolean)request.getAttribute("firstCall");

if(isFirstCall){
	
	//pageContext.setAttribute("noOfPages",noOfPages, pageContext.APPLICATION_SCOPE);
	pageContext.setAttribute("empCount",empCount, PageContext.APPLICATION_SCOPE);
}
%>
  <table>
    <% //pageContext.setAttribute("eid", "11"); 
    //int eid = (int)pageContext.getAttribute("eid");
    //boolean flag=true;
   
    if(empList!=null){ 
	 for(Employee emp : empList){
			out.println("<tr><td>"+emp.getEmpName() +"</td></tr>");
			 out.println("<tr><td> EmployeeId: "  +emp.getEmpId() + "</td></tr>"); 
		      out.println("<tr><td> Employee Name: " +emp.getEmpName() + "</td></tr>"); 
		       out.println("<tr><td> Employee Gender: " +emp.getGender() + "</td></tr>"); 
		       out.println("<tr><td> Employee Experience: "  +emp.getExperience() + "</td></tr>"); 
		       emp.getDept().getDeptName();
		
	 }
		//else out.println("Null");
    }//end for%> 
</table>
 
    <h2>using jstl Core taglib to print list</h2>
    <ul>
        <c:forEach items="${empList}" var="emp">
        <c:set var="eid" scope="session" value="40"/>
        <c:set var="ename" scope="session" value="${emp.empName}"/>
        <c:if test="${eid==emp.empId}">
            <li>${emp.empName }</li>
            <li>${emp.dob }</li>
            <li>${emp.empId}</li>
            <li>${emp.gender}</li>
            <li>${emp.experience}</li>
            <li>${emp.salary}</li>
            <li>${emp.dept.deptName}</li>
            </c:if>  
         <c:choose> 
         <c:when test="${emp.salary <= 10000}">
         	Salary is at the starting range
         </c:when>
          <c:when test="${emp.salary > 20000}"> && ${emp.salary <= 30000}">
         	Salary is at the middle range
         </c:when> 
         
         <c:otherwise>
        	 No comments!!
         </c:otherwise>
         </c:choose>
         <c:remove var="eid"/>
         <c:out value="${eid}"></c:out>
        </c:forEach>
    
    </ul> 
    
  <%-- <% ArrayList<Integer> empList1 = (ArrayList)request.getAttribute("empList1");%>
	 <h2>using jstl Core taglib to print list</h2>
    <ul>
        <c:forEach items="${empList1}" var="sal">
        
            <li>${sal}</li>
 
    	</c:forEach>
    	</ul>  --%>
    	
    	<a href="display.jsp">display</a> 
    	
  <p>Hibernate Pagination</p>
  <%
  for(int i=1;i<=noOfPages;i++){ %>
	  <a href="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath() %>%>/employee/getPage/<%=i%>">Page <%=i%></a>
	  <% 
  }
  %>
  <c:forEach var="i" begin="1" end="${noOfPages}">
  <a href="/getPage/${i}">Page ${i}</a>
  </c:forEach>
  
 <!-- <a href="prev">Prev</a>
 <a href="update">update</a> -->
 
</body>
</html>
