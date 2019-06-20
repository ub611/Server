package com.example.petMate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.petMate.command.MyPageAdoptCommand;
import com.example.petMate.command.MyPageBuyCommand;
import com.example.petMate.command.MyPageItemCommand;
import com.example.petMate.command.MyPagePetCommand;
import com.example.petMate.service.PetMateFacade;

@Controller
@RequestMapping("/mypage/{u_idx}")
public class MyPageDetailController {
	private static Logger logger = LoggerFactory.getLogger(MyPageDetailController.class);

	private PetMateFacade petmate;
	
	@Autowired
	public void setPetMate(PetMateFacade petMate) {
		this.petmate = petMate;
	}
	
	@RequestMapping("/item.do")
	public String getListItem(@PathVariable("u_idx")String userId, Model model) throws Exception{
		List<MyPageItemCommand> itemList = petmate.getItem(userId);
		List<MyPageBuyCommand> buyList = petmate.getBuyIamBuyer(userId);
		model.addAttribute("itemList", itemList);
		model.addAttribute("buyList", buyList);
		model.addAttribute( "u_idx", userId);
		logger.info(itemList.toString());
		logger.info(userId);
		
		return "/MyPageItem";
	}
	
	@RequestMapping("/pet.do")
	public String getLisPet(@PathVariable("u_idx")String userId, Model model) throws Exception{
		List<MyPagePetCommand> petList = petmate.getPet(userId);
		List<MyPageAdoptCommand> adoptList = petmate.getIamAdopter(userId);
		logger.info("After getPet");
		model.addAttribute("petList", petList);
		model.addAttribute("adoptList", adoptList);
		model.addAttribute("u_idx", userId);
		logger.info("After model attribute");
		return "/MyPagePet";
	}
}
