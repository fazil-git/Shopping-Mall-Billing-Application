package com.fazil.model;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fazil.business.InvoiceBusiness;
import com.fazil.dto.Customer;
import com.fazil.dto.Invoice;

public class InvoiceAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("customer");
		
		Enumeration<String> en=request.getParameterNames();
		Set<Integer> itemIds=new HashSet<Integer>();
		while(en.hasMoreElements()) {
			String name=en.nextElement();
			if(!name.equals("formid")) {
				String value=request.getParameter(name);
				System.out.println("invoice action (value) ="+value);
				int itemId=Integer.parseInt(value);
				System.out.println("invoice action (itemId) = "+itemId);
				itemIds.add(itemId);
			}
		}
		
		InvoiceBusiness invoiceBusiness=new InvoiceBusiness();
		Invoice invoice=invoiceBusiness.placeOrder(customer, itemIds);
		session.setAttribute("invoice", invoice);
		
		return "invoice.success";
	}

}
//Session has:
//customer, invoice