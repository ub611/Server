package com.example.petMate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.petMate.domain.Item;
import com.example.petMate.service.PetMateFacade;
@Controller
public class ItemController { 

	@Autowired
	private PetMateFacade petmate;
	
	private static Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	/*
	 * Item Get 
	 */
	@RequestMapping("/items.do")
	public String getLists(@RequestParam("sort") int sort, Model model) throws Exception {
		List<Item> items = petmate.getItemList(sort);
		if(items == null) {
			return "Error";
		}else {
			model.addAttribute("items", items);
			logger.info("items logggggg : " + items.toString());
			return "/itemList";
		}
	}
	
	/*
	 * Item detail Get
	 */
	@RequestMapping("/items/{item_idx}")
	public String getListByIdx(@PathVariable("item_idx") int item_idx, Model model) throws Exception {
		Item item = petmate.getItemByItemIdx(item_idx);
		if(item == null) {
			return "Error";
		}else {
			model.addAttribute("item", item);
			logger.info("items logggggg : " + item.toString());
			return "itemDetail";
		}
	}
	
	
	/*
	 * Item 등록 폼
	 */
//	@RequestMapping("/items/new.do")
//	public String addItemForm(Model model) throws Exception {
//		List<Item> items = petmate.getItemList();
//		model.addAttribute("items", items);
//		logger.info("items logggggg : " + items.toString());
//		return "/itemList";
//	}
	
	/*
	 * Item 등
	 */
//	@RequestMapping(value="/items/new.do",method = RequestMethod.POST)
//	public String addItem(@ModelAttribute("Item") ItemCommand itemCommand,  Model model) throws Exception {
//		List<Item> items = petmate.getItemList();
//		model.addAttribute("items", items);
//		logger.info("items logggggg : " + items.toString());
//		return "/itemList";
//	}
}
