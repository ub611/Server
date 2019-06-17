package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemImage implements Serializable{
	
	//itemImg
	private int ii_idx;
	private String ii_url;
	
	//item
	private int item_i_idx;

	public int getIi_idx() {
		return ii_idx;
	}

	public void setIi_idx(int ii_idx) {
		this.ii_idx = ii_idx;
	}

	public String getIi_url() {
		return ii_url;
	}

	public void setIi_url(String ii_url) {
		this.ii_url = ii_url;
	}

	public int getItem_i_idx() {
		return item_i_idx;
	}

	public void setItem_i_idx(int item_i_idx) {
		this.item_i_idx = item_i_idx;
	}	
}
