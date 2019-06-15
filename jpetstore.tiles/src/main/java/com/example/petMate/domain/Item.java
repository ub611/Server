package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable{
	
	//item
	private int itemIdx;
	private String itemTitle;
	private String itemPrice; 		//number 아닌가
	private int itemStock;		//재고
	private String itemDetail;		//상세설명
	
	//category
	private int catogoryIdx;
	
	//user
	private int userIdx;		//seller? buyer?

	//GetterSetter
	public int getItemIdx() {
		return itemIdx;
	}
	public void setItemIdx(int itemIdx) {
		this.itemIdx = itemIdx;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	public int getCatogoryIdx() {
		return catogoryIdx;
	}
	public void setCatogoryIdx(int catogoryIdx) {
		this.catogoryIdx = catogoryIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	
	
	
}
