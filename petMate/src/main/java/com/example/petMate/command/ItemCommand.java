package com.example.petMate.command;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ItemCommand {
	
	private String i_idx;
	private String i_title;
	private String i_price;
	private int i_stock;
	private String i_detail;
	private Date i_date;
	
//	private MultipartFile[] ii_url;
	private List<MultipartFile> ii_url;
	
	private int i_category;
	private String user_u_idx;
	
	

	public ItemCommand() {
		super();
	}



	public ItemCommand(String i_idx, String i_title, String i_price, int i_stock, String i_detail, Date i_date,
			int i_category, String user_u_idx) {
		super();
		this.i_idx = i_idx;
		this.i_title = i_title;
		this.i_price = i_price;
		this.i_stock = i_stock;
		this.i_detail = i_detail;
		this.i_date = i_date;
		this.i_category = i_category;
		this.user_u_idx = user_u_idx;
	}



	@Override
	public String toString() {
		return "ItemCommand [i_idx=" + i_idx + ", i_title=" + i_title + ", i_price=" + i_price + ", i_stock=" + i_stock
				+ ", i_detail=" + i_detail + ", i_date=" + i_date + ", ii_url=" + ii_url + ", i_category=" + i_category
				+ ", user_u_idx=" + user_u_idx + "]";
	}



	public boolean validateProperties(){
		return (i_title!=null && (!i_title.equals("")) &&  i_price!=null && (!i_price.equals("")) && i_stock > 0);
	}

	
	
	public String getI_idx() {
		return i_idx;
	}

	public void setI_idx(String i_idx) {
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

	public List<MultipartFile> getIi_url() {
		return ii_url;
	}



	public void setIi_url(List<MultipartFile> ii_url) {
		this.ii_url = ii_url;
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



	public Date getI_date() {
		return i_date;
	}

	public void setI_date(Date i_date) {
		this.i_date = i_date;
	}
	
	
}
