package com.example.petMate.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Item implements Serializable{
	
	//item
	private int i_idx;
	private String i_title;
	private String i_price; 		//number 아닌가
	private int i_stock;		//재고
	private String i_detail;		//상세설명
	private Date i_date;		// 등록 날
	
	//item image url
	private String[] ii_url;

	//category
	private int i_category;
	
	//user
	private String user_u_idx;		//seller? buyer?

	
	//GetterSetter
	public int getI_idx() {
		return i_idx;
	}

	public void setI_idx(int i_idx) {
		this.i_idx = i_idx;
	}

	public String getI_title() {
		return i_title;
	}

	public void setI_title(String i_title) {
		this.i_title = i_title;
	}

	public String getI_price() {
		return i_price;
	}

	public void setI_price(String i_price) {
		this.i_price = i_price;
	}

	public int getI_stock() {
		return i_stock;
	}

	public void setI_stock(int i_stock) {
		this.i_stock = i_stock;
	}

	public String getI_detail() {
		return i_detail;
	}

	public void setI_detail(String i_detail) {
		this.i_detail = i_detail;
	}

	public Date getI_date() {
		return i_date;
	}

	public void setI_date(Date i_date) {
		this.i_date = i_date;
	}

	public int getI_category() {
		return i_category;
	}

	public void setI_category(int i_category) {
		this.i_category = i_category;
	}

	public String getUser_u_idx() {
		return user_u_idx;
	}

	public void setUser_u_idx(String user_u_idx) {
		this.user_u_idx = user_u_idx;
	}

	public String[] getIi_url() {
		return ii_url;
	}

	public void setIi_url(String[] ii_url) {
		this.ii_url = ii_url;
	}
}
