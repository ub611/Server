package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Account implements Serializable {

  /* Private Fields */
	
	//user
	private String u_idx;
	private String u_name;
	private String u_address;
	private String u_phone;
	private String u_pw;
	private String u_salt;
	private String u_profile;
	
	public String getU_idx() {
		return u_idx;
	}
	public void setU_idx(String u_idx) {
		this.u_idx = u_idx;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_salt() {
		return u_salt;
	}
	public void setU_salt(String u_salt) {
		this.u_salt = u_salt;
	}
	public String getU_profile() {
		return u_profile;
	}
	public void setU_profile(String u_profile) {
		this.u_profile = u_profile;
	}
	
	public Account() {
	}
	
	public Account(String u_idx, String u_name, String u_address, String u_phone, String u_pw, String u_salt,
			String u_profile) {
		super();
		this.u_idx = u_idx;
		this.u_name = u_name;
		this.u_address = u_address;
		this.u_phone = u_phone;
		this.u_pw = u_pw;
		this.u_salt = u_salt;
		this.u_profile = u_profile;
	}
	
	
  
}