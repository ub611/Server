package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pet implements Serializable {

	//pet
	private int p_idx;
	private int p_age;
	private String p_gender;
	private String p_name;
	private String p_isinjection;
	
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

	public String getP_gender() {
		return p_gender;
	}

	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_isinjection() {
		return p_isinjection;
	}

	public void setP_isinjection(String p_isinjection) {
		this.p_isinjection = p_isinjection;
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
