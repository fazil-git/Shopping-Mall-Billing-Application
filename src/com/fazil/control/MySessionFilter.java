package com.fazil.control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MySessionFilter
 */
@WebFilter("*.do")
public class MySessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MySessionFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest=(HttpServletRequest) request;
		HttpServletResponse hResponse= (HttpServletResponse) response;
		
		HttpSession session=hRequest.getSession();
		if(session.isNew()) {
			String value=hRequest.getParameter("formid");
			if(value.equals("login")) {
				chain.doFilter(hRequest, hResponse);
			}else {
				session.invalidate();
				hResponse.sendRedirect("login.jsp");
			}
			
		}else {
			chain.doFilter(hRequest, hResponse);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
