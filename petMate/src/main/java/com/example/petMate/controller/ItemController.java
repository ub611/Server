package com.example.petMate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.petMate.domain.Item;
import com.example.petMate.service.PetMateFacade;
@Controller
public class ItemController { 

	@Autowired
	private PetMateFacade petmate;
	
	private static Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@RequestMapping("/items.do")
	public String handleRequest(Model model) throws Exception {
		List<Item> items = petmate.getItemList();
		model.addAttribute("items", items);
		logger.info("items logggggg : " + items.toString());
		return "/itemList";
	}
	
	@RequestMapping("/items/all.do")
	public String items(Model model) throws Exception {
		List<Item> items = petmate.getItemList();
		model.addAttribute("items", items);
		logger.info("items logggggg : " + items.toString());
		return "/itemList";
	}
}
