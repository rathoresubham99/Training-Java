package org.impelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/secondServlet")
public class SecondController extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("initializing SecondController");
	
	}
	
	//handles get method
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter pw=response.getWriter();
		//Cookie cookie[]=request.getCookies();
		/*String userName=null;
		if(cookie!=null){
			userName=cookie[0].getValue();
		}*/
		
		
		HttpSession session=request.getSession(false);
		String userName=null;
		if(session!=null)
		userName=(String)session.getAttribute("userName");
		
		if(userName==null)
			pw.println("invalid user");
			else
			response.setContentType("text.html");
		pw.println("<html><body bgcolor='green'>");
			pw.println("Hello ,Welcome " + userName);
			pw.println("</body></html>");
	}
}
