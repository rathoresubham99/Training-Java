package org.impelsys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
//@WebFilter("/AuthenticationFilter")
@WebFilter(urlPatterns="/hello", servletNames={"SecondController"})
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//chk if user looged in for every request
//		HttpServletRequest req = (HttpServletRequest) request; 
//		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("This is Authentication filter");
		HttpSession session =((HttpServletRequest) request).getSession(false);
		String userName=null;
		if(session!=null)
		userName=(String) session.getAttribute("userName");
		if(userName!=null)
		{
		// pass the request along the filter chain
		System.out.println("User Already Logged in");
		chain.doFilter(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	

}

