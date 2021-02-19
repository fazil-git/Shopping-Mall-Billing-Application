package com.fazil.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String customerAddress;

	
	public final int getCustomerId() {
		return customerId;
	}
	public final void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public final String getCustomerName() {
		return customerName;
	}
	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public final String getCustomerAddress() {
		return customerAddress;
	}
	public final void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

}
