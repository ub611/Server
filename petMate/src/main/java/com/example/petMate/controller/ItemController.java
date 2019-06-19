package com.example.petMate.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.domain.Item;
import com.example.petMate.service.PetMateFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@SessionAttributes("itemCommand")
public class ItemController { 

	@Autowired
	private PetMateFacade petmate;
	
	private static Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	
	@ModelAttribute("itemCommand")
	public ItemCommand formData( ) {
		return  new ItemCommand();
	}
	
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
	 * Item 등록 new -> step1
	 */
	@RequestMapping(value="/items/step1.do", method = RequestMethod.GET)
	public String addItem(@ModelAttribute("itemCommand") ItemCommand itemCommand,
			BindingResult result,
			HttpServletRequest request,
			HttpServletResponse response, SessionStatus status) throws Exception {
		return "NewItemForm";
	}
	
	/*
	 * Item 등록 step1
	 */
	@RequestMapping(value="/items/step1.do", method = RequestMethod.POST)
	public String addItemGet(@ModelAttribute("itemCommand") ItemCommand itemCommand,
			BindingResult result,
			HttpServletRequest request,
			HttpServletResponse response, SessionStatus status) throws Exception {
		String u_idx = (String) request.getSession().getAttribute("u_idx");

		u_idx = "3";
		
		if(u_idx == null || u_idx.equals("") ) {
			//로그인 페이지로 리다이렉트!
			response.sendRedirect(request.getContextPath() + "/items.do");
		}
		
		if(!itemCommand.validateProperties()) {
			logger.info("new Item logggggg : " + itemCommand.toString());
			return "Error";
		}
		try {
    		logger.info("new Item : " + itemCommand.toString());
			itemCommand.setUser_u_idx(Integer.valueOf(u_idx));
			return "NewItemImages";
		}catch(Exception e) {
            e.printStackTrace();
            return "Error";
		}
	}
	
	/*
	 * Item 등록 summit
	 */
	@RequestMapping(value="/items/new.do", method = RequestMethod.POST)
	public String addItem(@ModelAttribute("itemCommand") ItemCommand itemCommand,
			BindingResult result,
			HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam("ii_url") MultipartFile ii_url, 
			@RequestParam("ii_url1") MultipartFile ii_url1, 
			@RequestParam("ii_url2") MultipartFile ii_url2, 
			@RequestParam("ii_url3") MultipartFile ii_url3, 
			@RequestParam("ii_url4") MultipartFile ii_url4, 
			SessionStatus status) throws Exception {
		try {
			List<MultipartFile> url = new ArrayList<MultipartFile>();
			if(!ii_url.isEmpty()) {
				url.add(ii_url);
			}if(!ii_url1.isEmpty()) {
				url.add(ii_url1);
			}if(!ii_url2.isEmpty()) {
				url.add(ii_url2);
			}if(!ii_url3.isEmpty()) {
				url.add(ii_url3);
			}if(!ii_url4.isEmpty()) {
				url.add(ii_url4);
			}
			itemCommand.setIi_url(url);
            petmate.createItem(itemCommand);
            status.setComplete();
    		return "NewItemConfirm";
		}catch(Exception e) {
            e.printStackTrace();
            return "Error";
		}
	}
	
	/*
	 * Item 수정
	 */
//	@RequestMapping(value="/items/edit.do",method = RequestMethod.POST)
//	public String editItem(@ModelAttribute("Item") ItemCommand itemCommand,  Model model) throws Exception {
//		List<Item> items = petmate.getItemList();
//		model.addAttribute("items", items);
//		logger.info("items logggggg : " + items.toString());
//		return "/";
//	}
	
	/*
	 * Item 수량 변경
	 */
//	@RequestMapping(value="/items/new.do",method = RequestMethod.POST)
//	public String editItemStock(@ModelAttribute("Item") ItemCommand itemCommand,  Model model) throws Exception {
//		List<Item> items = petmate.getItemList();
//		model.addAttribute("items", items);
//		logger.info("items logggggg : " + items.toString());
//		return "/";
//	}
	
	
	/*
	 * Item 삭제
	 */
//	@RequestMapping(value="/items/new.do",method = RequestMethod.POST)
//	public String deleteItem(@ModelAttribute("Item") ItemCommand itemCommand,  Model model) throws Exception {
//		List<Item> items = petmate.getItemList();
//		model.addAttribute("items", items);
//		logger.info("items logggggg : " + items.toString());
//		return "/";
//	}

}
