package com.fazil.control;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fazil.model.Action;

public class RequestProcessor implements Cloneable {
	
	public RequestProcessor getClone() {
		try {
			return (RequestProcessor) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext ctx=request.getServletContext();
			Properties prop=(Properties) ctx.getAttribute("prop");
			
			String formid=(String) request.getParameter("formid");
			String actionClass=prop.getProperty(formid);
			
			Action action=(Action) Class.forName(actionClass).getDeclaredConstructor().newInstance();
			String result=action.execute(request, response);
			String nextAction=prop.getProperty(result);
			
			RequestDispatcher rd=request.getRequestDispatcher(nextAction);
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
