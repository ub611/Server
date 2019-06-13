package com.example.petMate.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PetImage implements Serializable{
	
	//image
	private int piIdx;
	private String piUrl;
	
	//pet
	private int petIdx;

	
	//GetterSetter
	public int getPiIdx() {
		return piIdx;
	}

	public void setPiIdx(int piIdx) {
		this.piIdx = piIdx;
	}

	public String getPiUrl() {
		return piUrl;
	}

	public void setPiUrl(String piUrl) {
		this.piUrl = piUrl;
	}

	public int getPetIdx() {
		return petIdx;
	}

	public void setPetIdx(int petIdx) {
		this.petIdx = petIdx;
	}
	
	
}
