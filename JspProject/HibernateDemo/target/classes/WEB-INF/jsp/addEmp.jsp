<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error{

}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
<h3>${HeaderStatus}</h3>
<h1>Add New Employee</h1>  
       <springform:form method="post" action="add" modelAttribute="emp" autocomplete="on">  
       <%-- 	<springform:errors path="errors" cssClass="error"/>  --%>  
       <%-- <springform:errors path="*" cssClass="error"/> --%>
       	<br><br>
       	<springform:errors path="name" cssClass="error"/>
       <springform:label path="name">Employee Name</springform:label>
       <springform:input type="text" path="name"  /></td>  
       <br><br> 
       <springform:errors path="salary" cssClass="error"/>      
        <springform:label path="salary">Salary</springform:label>
       <springform:input type="text" path="salary"  /></td>  
       <br><br> 
       <springform:errors path="designation" cssClass="error"/> 
       <springform:label path="designation">Designation</springform:label>
       <springform:input type="text" path="designation"  /></td>  
       <br><br> 
        <springform:errors path="empExperience" cssClass="error"/> 
        <springform:label path="empExperience">Employee Experience</springform:label>
       <springform:input type="text" path="empExperience"  /></td>  
       <br><br>
       <springform:errors path="dateOfBirth" cssClass="error"/> 
       <springform:label path="dateOfBirth">Date Of Birth(in dd/MM/yyyy)</springform:label>
       <springform:input path="dateOfBirth" type="date" cssClass="datepicker" /></td>  
        <input type="submit" value="submit"/>
       
       <br><br>
       </springform:form>    
</body>
</html>