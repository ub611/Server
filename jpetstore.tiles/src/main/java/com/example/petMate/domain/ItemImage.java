package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemImage implements Serializable{
	
	//itemImg
	private int itemImageIdx;
	private String itemImageUrl;
	
	//item
	private int itemIdx;

	//GetterSetter
	public int getItemImageIdx() {
		return itemImageIdx;
	}

	public void setItemImageIdx(int itemImageIdx) {
		this.itemImageIdx = itemImageIdx;
	}

	public String getItemImageUrl() {
		return itemImageUrl;
	}

	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}

	public int getItemIdx() {
		return itemIdx;
	}

	public void setItemIdx(int itemIdx) {
		this.itemIdx = itemIdx;
	}
	
	
	
}
