package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Account implements Serializable {

  /* Private Fields */
	
	//user
	private int uesrIdx;
	private String userName;
	private String address;
	private String phone;
	private String password;
	private String salt;
	
	
	//GetterSetter
	public int getUesrIdx() {
		return uesrIdx;
	}
	public String getUserName() {
		return userName;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}
	public String getSalt() {
		return salt;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setUesrIdx(int uesrIdx) {
		this.uesrIdx = uesrIdx;
	}
	
  
}