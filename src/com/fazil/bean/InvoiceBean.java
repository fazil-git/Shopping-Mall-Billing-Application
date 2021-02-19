package com.fazil.bean;

import java.util.HashSet;
import java.util.Set;

import com.fazil.dto.Item;
import com.fazil.dto.Transaction;

public class InvoiceBean {
	Set<Transaction> trxs;
	Set<Item> items = new HashSet<Item>();
	int totalcost;
	public Set<Item> getItems() {
		for(Transaction trx:trxs) {
			Item item=trx.getItem();
			totalcost+=item.getPrice();
			items.add(item);
		}
		return items;
	}
	public final Set<Transaction> getTrxs() {
		return trxs;
	}
	public final void setTrxs(Set<Transaction> trxs) {
		this.trxs = trxs;
	}
	public final void setItems(Set<Item> items) {
		this.items = items;
	}
	public final int getTotalcost() {
		return totalcost;
	}
	public final void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
}
