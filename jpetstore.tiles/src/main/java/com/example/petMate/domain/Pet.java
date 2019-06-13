package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pet implements Serializable {

	//pet
	private int petIdx;
	private int petAge;
	private String petGender;
	private String petName;
	private String petIsInjection;
	
	//user
	private int userIdx;
	
	//category
	private int categoryIdx;

	
	//GetterSetter
	public int getPetIdx() {
		return petIdx;
	}

	public void setPetIdx(int petIdx) {
		this.petIdx = petIdx;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetIsInjection() {
		return petIsInjection;
	}

	public void setPetIsInjection(String petIsInjection) {
		this.petIsInjection = petIsInjection;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public int getCategoryIdx() {
		return categoryIdx;
	}

	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	
	
}
