package org.impelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/hello",initParams={
		@WebInitParam(name="driverName",value="oracle.jdbc.odbc.OracleDriver"),
		@WebInitParam(name="dbuserName",value="user1")
})
public class HelloWorldController extends HttpServlet{
	private String userName;
	private int hitCounter;
	
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext context=config.getServletContext();
		String projectName = context.getInitParameter("projectName");
		
		
		String driverName=config.getInitParameter("driverName");
		System.out.println("loading driver : "+ driverName);
		
		
		System.out.println("initializing project:  " + projectName);
		hitCounter=0;
	}
	
	//handles get method
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		System.out.println("Handling incoming request.... ");
		hitCounter++;
		PrintWriter pw = response.getWriter();
		//pw.println("Hello");
		

		//Set response content type
		//response.setContentType("text/html"); //MIME type
		//PrintWriter pw1 = response.getWriter();
		//pw1.println("<h2>");
		//userName=request.getParameter("userName");
		//pw1.println("hello ,Good Morning  "+ "u  have visited "+ hitCounter + "  times");
	}
		//handles post method
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Handling Post method");
		response.setContentType("text/html");
		response.setHeader("Cache-Control","no-store");
		response.setDateHeader("Expires",0);
		//RequestDispatcher reqDispatcher = request.getRequestDispatcher("secondServlet");
		//reqDispatcher.include(request, response);
		//System.out.println("redirecting to second Serclet");
		//response.sendRedirect("www.google.com");
		
		PrintWriter pw = response.getWriter();
		userName=request.getParameter("userName");
		pw.println("Hello"+ userName);
		//save user name
		/*Cookie userCookie=new Cookie("uname", userName);
		userCookie.setMaxAge(5); //milliseconds
		response.addCookie(userCookie);*/
		
		
		HttpSession session=request.getSession();
		session.setAttribute("userName", userName);
		System.out.println("Redirecting to second Servlet");
		response.setStatus(307);
		//System.out.println("redirecting to secondServlet");
		response.sendRedirect("secondServlet");
		/*pw.println("<form action='POST'>");
		pw.println("<input type='submit' value='Go in'>");
		pw.println("</form>");*/
		//RequestDispatcher reqDispatcher = request.getRequestDispatcher("secondServlet");
		//reqDispatcher.forward(request, response);
		//reqDispatcher.include(request, response);

		
	}
	
	
		public void destroy()
		{
			//cleanup activities
			System.out.println("in Destroy" );
		}
		
	}


