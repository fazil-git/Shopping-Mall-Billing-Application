package com.fazil.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fazil.business.AuthBusiness;
import com.fazil.dto.Customer;

public class AuthAction extends Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession hsession=request.getSession();
		hsession.setMaxInactiveInterval(10*60);
		
		String custId=request.getParameter("customerId");
		int customerId=Integer.parseInt(custId);
		
		AuthBusiness auth=new AuthBusiness();
		Customer customer=auth.verifyCustomer(customerId);
		if(customer!=null) {
			hsession.setAttribute("customer", customer);
			return "login.success";
		}
		return "login.fail";
	}
}
