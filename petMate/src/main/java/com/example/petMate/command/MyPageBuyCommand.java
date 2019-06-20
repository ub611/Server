package com.example.petMate.command;

import java.sql.Date;

public class MyPageBuyCommand {
	private Date b_date; //buy.b_date 
	private String seller_idx; //buy.
	private String i_title;//item.
	private String i_price;//item.i_price, 
	private String i_detail; //item.i_detail
	
	public MyPageBuyCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyPageBuyCommand(Date b_date, String seller_idx, String i_title, String i_price, String i_detail) {
		super();
		this.b_date = b_date;
		this.seller_idx = seller_idx;
		this.i_title = i_title;
		this.i_price = i_price;
		this.i_detail = i_detail;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public String getSeller_idx() {
		return seller_idx;
	}
	public void setSeller_idx(String seller_idx) {
		this.seller_idx = seller_idx;
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
	public String getI_detail() {
		return i_detail;
	}
	public void setI_detail(String i_detail) {
		this.i_detail = i_detail;
	}
	
	
}
