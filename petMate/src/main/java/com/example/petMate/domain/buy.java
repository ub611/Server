package com.example.petMate.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class buy implements Serializable{
	
	//but
	private int b_idx;
	private Date b_date;
	private int b_amount;
	private String b_state;
	
	//uesr
	private String seller_idx;		
	private String buyer_idx;	
	
	//items
	private List<LineItem> lineItems = new ArrayList<LineItem>();

	public int getB_idx() {
		return b_idx;
	}

	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public int getB_amount() {
		return b_amount;
	}

	public void setB_amount(int b_amount) {
		this.b_amount = b_amount;
	}

	public String getB_state() {
		return b_state;
	}

	public void setB_state(String b_state) {
		this.b_state = b_state;
	}

	public String getSeller_idx() {
		return seller_idx;
	}

	public void setSeller_idx(String seller_idx) {
		this.seller_idx = seller_idx;
	}

	public String getBuyer_idx() {
		return buyer_idx;
	}

	public void setBuyer_idx(String buyer_idx) {
		this.buyer_idx = buyer_idx;
	}
	
	public void setLineItems(List<LineItem> lineItems) { this.lineItems = lineItems; }
	public List<LineItem> getLineItems() { return lineItems; }
	
	
	public void initOrder(Account account, Cart cart) {
		seller_idx = account.getU_idx();
	    b_date = new Date();

	    b_amount = cart.getSubTotal();
	    
	    Iterator<CartItem> i = cart.getAllCartItems();
	    while (i.hasNext()) {
	    	CartItem cartItem = (CartItem) i.next();
	    	addLineItem(cartItem);
	    }
	  }

	  public void addLineItem(CartItem cartItem) {
	    LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
	    addLineItem(lineItem);
	  }

	  public void addLineItem(LineItem lineItem) {
	    lineItems.add(lineItem);
	  }
}
