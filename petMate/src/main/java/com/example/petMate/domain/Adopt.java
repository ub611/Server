package com.example.petMate.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Adopt implements Serializable{
	
	//adopt
	private int a_idx;
	private Date a_date;
	private int a_state;
	private String a_title;
	private String a_content;
	
	//user
	private String adopter_idx;		//분양해갈사람
	private String owner_idx;	//분양 해주는 사람
	
	//pet
	private int pet_p_idx;		
	//GetterSetter

	public int getA_idx() {
		return a_idx;
	}

	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}

	public Date getA_date() {
		return a_date;
	}

	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}

	public int getA_state() {
		return a_state;
	}

	public void setA_state(int a_state) {
		this.a_state = a_state;
	}

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}

	public String getA_content() {
		return a_content;
	}

	public void setA_content(String a_content) {
		this.a_content = a_content;
	}

	public String getAdopter_idx() {
		return adopter_idx;
	}

	public void setAdopter_idx(String adopter_idx) {
		this.adopter_idx = adopter_idx;
	}

	public String getOwner_idx() {
		return owner_idx;
	}

	public void setOwner_idx(String owner_idx) {
		this.owner_idx = owner_idx;
	}

	public int getPet_p_idx() {
		return pet_p_idx;
	}

	public void setPet_p_idx(int pet_p_idx) {
		this.pet_p_idx = pet_p_idx;
	}
	
}