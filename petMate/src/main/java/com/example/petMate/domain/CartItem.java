package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartItem implements Serializable {
	/* Private Fields */

	private Item item;
	private int quantity;
	//private boolean inStock =false;

	/* JavaBeans Properties */

	//public boolean isInStock() { return inStock; }
	//public void setInStock(boolean inStock) { this.inStock = inStock; }

	public Item getItem() { return item; }
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getQuantity() { return quantity; }
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getTotalPrice() {
		String result = "";
		if (item != null) {
			result += Integer.parseInt(item.getI_price()) * item.getI_stock();
		}
		else {
			result += "0";
		}
		return result;
	}
	
	public void incrementQuantity() {
		quantity++;
	}

}
