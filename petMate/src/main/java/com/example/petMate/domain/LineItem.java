package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LineItem implements Serializable {
	/* Private Fields */
	private int orderId;
	private int lineNumber;
	private int quantity;
	private int itemId;
	private String unitPrice;
	private Item item;

  /* Constructors */
	public LineItem() {}

	public LineItem(int lineNumber, CartItem cartItem) {
		this.lineNumber = lineNumber;
		this.quantity = cartItem.getQuantity();
		this.itemId = cartItem.getItem().getI_idx();
		this.unitPrice = cartItem.getItem().getI_price();
		this.item = cartItem.getItem();
	}

  /* JavaBeans Properties */
	public int getOrderId() { return orderId; }
	public void setOrderId(int orderId) { this.orderId = orderId; }

	public int getLineNumber() { return lineNumber; }
	public void setLineNumber(int lineNumber) { this.lineNumber = lineNumber; }

	public int getItemId() { return itemId; }
	public void setItemId(int itemId) { this.itemId = itemId; }

	public String getUnitPrice() { return unitPrice; }
	public void setUnitPrice(String unitprice) { this.unitPrice = unitprice; }

	public Item getItem() { return item; }
	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return Integer.parseInt(this.unitPrice) * this.quantity;
	}
}
