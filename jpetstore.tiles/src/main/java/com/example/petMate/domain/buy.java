package com.example.petMate.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class buy implements Serializable{
	
	//but
	private int buyIdx;
	private Date buytDate;
	private int buyAmount;
	private String buyState;
	
	//uesr
	private int sellerIdx;		
	private int buyerIdx;	
	
	//item
	private int itemIdx;		//what item

	//GetterSetter
	public int getBuyIdx() {
		return buyIdx;
	}

	public void setBuyIdx(int butIdx) {
		this.buyIdx = butIdx;
	}

	public Date getBuytDate() {
		return buytDate;
	}

	public void setBuytDate(Date buytDate) {
		this.buytDate = buytDate;
	}

	public int getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}

	public String getBuyState() {
		return buyState;
	}

	public void setBuyState(String buyState) {
		this.buyState = buyState;
	}

	public int getSellerIdx() {
		return sellerIdx;
	}

	public void setSellerIdx(int sellerIdx) {
		this.sellerIdx = sellerIdx;
	}

	public int getBuyerIdx() {
		return buyerIdx;
	}

	public void setBuyerIdx(int buyerIdx) {
		this.buyerIdx = buyerIdx;
	}

	public int getItemIdx() {
		return itemIdx;
	}

	public void setItemIdx(int itemIdx) {
		this.itemIdx = itemIdx;
	}
	
	
	
}
