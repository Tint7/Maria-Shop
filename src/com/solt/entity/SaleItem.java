package com.solt.entity;

public class SaleItem {
	private int saleitemId;
	private int unitPrice;
	private int count;
	private int total;
	private int itemId;
	private int invoiceId;
	public int getSaleitemId() {
		return saleitemId;
	}
	public void setSaleitemId(int saleitemId) {
		this.saleitemId = saleitemId;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	
}
