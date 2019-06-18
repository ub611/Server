package com.example.petMate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.petMate.service.PetMateFacade;

@Controller
//@RequestMapping("/mypage.do")
public class MyPageController {
	private static Logger logger = LoggerFactory.getLogger(MyPageController.class);

	private PetMateFacade petMate;
	
	@Autowired
	public void setPetStore(PetMateFacade petMate) {
		this.petMate = petMate;
	}
	
	

}
