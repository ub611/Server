package com.example.petMate.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.petMate.service.PetMateFacade;

@Controller
@RequestMapping("/mypage/{u_idx}")
public class MyPageDetailController {
	private static Logger logger = LoggerFactory.getLogger(MyPageDetailController.class);

	@Autowired
	private PetMateFacade petmate;
	
	@RequestMapping("/item.do")
	public String getListItem(@PathVariable("u_idx")String userId, Model model) throws Exception{
		//item list가져오기
		//buy list 가져오기
		//command객체 생성, bootstrap찾기
		
		logger.info(userId);
		
		return "/MyPageItem";
	}
	
	@RequestMapping("/pet.do")
	public String getLisPet(@PathVariable("u_idx")String userId, Model model) throws Exception{
		//list 추가하기
		//sessio에서 user_idx 가져와
		
		return "/MyPagePet";
	}
}
