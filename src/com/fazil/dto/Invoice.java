package com.fazil.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Invoice {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int billNo;
	private Date billDate;
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	private int discount;
	private int gst;
	@OneToMany(mappedBy = "invoice")
	private Set<Transaction> trxs=new HashSet<Transaction>(0);
	
	public final Set<Transaction> getTrx() {
		return trxs;
	}
	public final void setTrx(Set<Transaction> trx) {
		this.trxs = trx;
	}
	public final int getBillNo() {
		return billNo;
	}
	public final void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public final Date getBillDate() {
		return billDate;
	}
	public final void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public final Customer getCustomer() {
		return customer;
	}
	public final void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public final int getDiscount() {
		return discount;
	}
	public final void setDiscount(int discount) {
		this.discount = discount;
	}
	public final int getGst() {
		return gst;
	}
	public final void setGst(int gst) {
		this.gst = gst;
	}
}
