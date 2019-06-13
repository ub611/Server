package com.example.petMate.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Adopt implements Serializable{
	
	//adopt
	private int adoptIdx;
	private Date adoptDate;
	private String adoptState;
	
	//user
	private int adopterIdx;		//분양해갈사람
	private int onwerIdx;	//분양 해주는 사람
	
	//pet
	private int petIdx;		//필요 없는 필드 가튼데 , , ,
	
	//GetterSetter

	
	

}
