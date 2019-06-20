package com.example.petMate.command;

import java.sql.Date;

public class MyPageItemCommand {
	private String i_title;
	private String i_price;
	private int i_stock;
	private String i_detail;
	private Date i_date;
	
	public MyPageItemCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyPageItemCommand(String i_title, String i_price, int i_stock, String i_detail, Date i_date) {
		super();
		this.i_title = i_title;
		this.i_price = i_price;
		this.i_stock = i_stock;
		this.i_detail = i_detail;
		this.i_date = i_date;
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
	
	

}
