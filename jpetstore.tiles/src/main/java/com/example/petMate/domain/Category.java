package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable{
	
	//category
	private int categoryIdx;
	private String categoryNane;

	//GetterSetter
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public String getCategoryNane() {
		return categoryNane;
	}
	public void setCategoryNane(String categoryNane) {
		this.categoryNane = categoryNane;
	}
	
	
}
