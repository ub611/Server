package com.example.petMate.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class PetImage implements Serializable{
	
	//image
	private int pi_idx;
	private MultipartFile pi_url;
	
	//pet
	private int pet_p_idx;

	public int getPi_idx() {
		return pi_idx;
	}

	public void setPi_idx(int pi_idx) {
		this.pi_idx = pi_idx;
	}


	public MultipartFile getPi_url() {
		return pi_url;
	}

	public void setPi_url(MultipartFile pi_url) {
		this.pi_url = pi_url;
	}

	public int getPet_p_idx() {
		return pet_p_idx;
	}

	public void setPet_p_idx(int pet_p_idx) {
		this.pet_p_idx = pet_p_idx;
	}
}
