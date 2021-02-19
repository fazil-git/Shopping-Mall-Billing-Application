package com.fazil.dao;

import java.util.Set;

import com.fazil.dto.Invoice;
import com.fazil.dto.Item;

public interface TransactionDAO {
	public void setTransaction(Invoice invoice, Set<Item> items);
}
