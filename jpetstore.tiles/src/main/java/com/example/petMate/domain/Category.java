package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable{
	
	//category
	private int c_idx;
	private String c_name;
	
	
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}	
}
