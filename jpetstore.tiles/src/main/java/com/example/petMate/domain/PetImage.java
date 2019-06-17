package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PetImage implements Serializable{
	
	//image
	private int pi_idx;
	private String pi_url;
	
	//pet
	private int pet_p_idx;

	public int getPi_idx() {
		return pi_idx;
	}

	public void setPi_idx(int pi_idx) {
		this.pi_idx = pi_idx;
	}

	public String getPi_url() {
		return pi_url;
	}

	public void setPi_url(String pi_url) {
		this.pi_url = pi_url;
	}

	public int getPet_p_idx() {
		return pet_p_idx;
	}

	public void setPet_p_idx(int pet_p_idx) {
		this.pet_p_idx = pet_p_idx;
	}
}
