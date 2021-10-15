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
 * Servlet Filter implementation class IPAddressFilter
 */
@WebFilter(urlPatterns="/*", description="Print IP Address of request origin")
public class IPAddressFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IPAddressFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("in constructor");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy method");
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException,ServletException {
		// TODO Auto-generated method stub
		String ipAddress=request.getRemoteAddr();
		System.out.println("request originated from : " + ipAddress);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

