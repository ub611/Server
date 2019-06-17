package com.example.petMate.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class buy implements Serializable{
	
	//but
	private int b_idx;
	private Date b_date;
	private int b_amount;
	private String b_state;
	
	//uesr
	private int seller_idx;		
	private int buyer_idx;	
	
	//item
	private int item_idx;		//what item

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

	public int getSeller_idx() {
		return seller_idx;
	}

	public void setSeller_idx(int seller_idx) {
		this.seller_idx = seller_idx;
	}

	public int getBuyer_idx() {
		return buyer_idx;
	}

	public void setBuyer_idx(int buyer_idx) {
		this.buyer_idx = buyer_idx;
	}

	public int getItem_idx() {
		return item_idx;
	}

	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}

}
