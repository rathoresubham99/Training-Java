package com.impelsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
    	res.setHeader("Cache-Control", "no-store"); //fresh page fetch from server
		res.setDateHeader("Expires", 0);
		PrintWriter out = res.getWriter();
		String user = req.getParameter("uname");
		String pass = req.getParameter("psw");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_data","root","Sunny@001");	
			Statement statement = con.createStatement();
	
			ResultSet rSet = statement.executeQuery("select * from login where username='"+user+"' and pass='"+pass+"'");
			System.out.println("This is line 30");
			if(rSet.next())
			{
				
				res.sendRedirect("/home.html");
			}
			else{
				out.println("The Username or the password entered is Wrong!!! Please try again...");
			}
	con.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
}
