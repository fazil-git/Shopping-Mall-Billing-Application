package com.fazil.dao;

public class InvoiceDAOImpl implements InvoiceDAO {
	private static InvoiceDAOImpl obj;
	private InvoiceDAOImpl() {
		
	}
	public static InvoiceDAOImpl createInvoiceDAO() {
		if(obj==null) obj=new InvoiceDAOImpl();
		return obj;
	}
}
