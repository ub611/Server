package com.example.petMate.command;

public class MyPagePetCommand {
	private int p_idx;
	private int p_age;
	private int p_gender;
	private String p_name;
	private int p_isInjection;
	private String p_cate_detail;
	private String c_name;
	//pet.p_age, pet.p_gender, pet.p_name, pet.p_isInjection, 
	//pet.p_cate_detail, category.c_name*
	
	public MyPagePetCommand(int p_idx, int p_age, int p_gender, String p_name, int p_isInjection, String p_cate_detail,
			String c_name) {
		super();
		this.p_idx = p_idx;
		this.p_age = p_age;
		this.p_gender = p_gender;
		this.p_name = p_name;
		this.p_isInjection = p_isInjection;
		this.p_cate_detail = p_cate_detail;
		this.c_name = c_name;
	}
	
	
	public int getP_idx() {
		return p_idx;
	}


	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}


	public MyPagePetCommand() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	
}
