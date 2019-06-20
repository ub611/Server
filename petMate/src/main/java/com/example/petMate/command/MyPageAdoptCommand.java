package com.example.petMate.command;

import java.sql.Date;

public class MyPageAdoptCommand {
	private int a_idx;
	private int p_age; 	//pet.p_age, 
	private int p_gender;	//pet.p_gender, 
	private String p_name;	//pet.p_name, 
	private int p_isInjection;	//pet.p_isInjection, 
	private String p_cate_detail;	//pet.p_cate_detail, 
	private String owner_idx;	//adopt.owner_idx, 
	private String a_state;		//adopt.a_state, 
	private Date a_date;	//adopt.a_date, category.c_name
	private String c_name;
	
	public MyPageAdoptCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyPageAdoptCommand(int a_idx, int p_age, int p_gender, String p_name, int p_isInjection, String p_cate_detail,
			String owner_idx, String a_state, Date a_date, String c_name) {
		super();
		this.a_idx = a_idx;
		this.p_age = p_age;
		this.p_gender = p_gender;
		this.p_name = p_name;
		this.p_isInjection = p_isInjection;
		this.p_cate_detail = p_cate_detail;
		this.owner_idx = owner_idx;
		this.a_state = a_state;
		this.a_date = a_date;
		this.c_name = c_name;
	}
	
	public int getA_idx() {
		return a_idx;
	}

	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
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
	public String getP_cate_detail() {
		return p_cate_detail;
	}
	public void setP_cate_detail(String p_cate_detail) {
		this.p_cate_detail = p_cate_detail;
	}
	public String getOwner_idx() {
		return owner_idx;
	}
	public void setOwner_idx(String owner_idx) {
		this.owner_idx = owner_idx;
	}
	public String getA_state() {
		return a_state;
	}
	public void setA_state(String a_state) {
		this.a_state = a_state;
	}
	public Date getA_date() {
		return a_date;
	}
	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	
}
