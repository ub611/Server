package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pet implements Serializable {

	//pet
	private int p_idx;
	private int p_age;
	private int p_gender;
	private String p_name;
	private int p_isInjection;
	private int p_cate;
	private String p_cate_detail;
	
	//user
	private String user_u_idx;
	
	//category
	private int category_c_idx;

	public int getP_idx() {
		return p_idx;
	}

	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}

	public int getP_age() {
		return p_age;
	}

	public void setP_age(int p_age) {
		this.p_age = p_age;
	}

	public int getP_gender() {
		return p_gender;
	}

	public void setP_gender(int p_gender) {
		this.p_gender = p_gender;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_isInjection() {
		return p_isInjection;
	}

	public void setP_isInjection(int p_isInjection) {
		this.p_isInjection = p_isInjection;
	}

	public int getP_cate() {
		return p_cate;
	}

	public void setP_cate(int p_cate) {
		this.p_cate = p_cate;
	}

	public String getP_cate_detail() {
		return p_cate_detail;
	}

	public void setP_cate_detail(String p_cate_detail) {
		this.p_cate_detail = p_cate_detail;
	}

	public String getUser_u_idx() {
		return user_u_idx;
	}

	public void setUser_u_idx(String user_u_idx) {
		this.user_u_idx = user_u_idx;
	}

	public int getCategory_c_idx() {
		return category_c_idx;
	}

	public void setCategory_c_idx(int category_c_idx) {
		this.category_c_idx = category_c_idx;
	}

	
}