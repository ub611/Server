package com.example.petMate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.petMate.service.PetMateFacade;

@Controller
@RequestMapping("/updateAccount.do")
public class MyPageController {
	private static Logger logger = LoggerFactory.getLogger(MyPageController.class);

	private PetMateFacade petMate;
	
	@Value("EditAccountForm")
	private String formViewName;
	
	@Value("index")
	private String successViewName;
	
	@Autowired
	public void setPetStore(PetMateFacade petMate) {
		this.petMate = petMate;
	}
	
	@ModelAttribute("AccountForm")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		HttpSession session = request.getSession(); 
		String isLogin = (String) session.getAttribute("u_idx");
		if (isLogin != null) {	// edit an existing account
			logger.info("session != null");
			return new AccountForm(petMate.getAccountById((String)session.getAttribute("u_idx")));
		}
		else {	// create a new account
			return new AccountForm();
		}
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("AccountForm") AccountForm account,
			BindingResult result) throws Exception {
		
		logger.info(account.getAccount().getU_idx());
		
//		validator.validate(account, result);

		if (result.hasErrors()) return formViewName;
		

		try {
			logger.info("update Account");
			petMate.updateAccount(account.getAccount());
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.u_idx", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
//		
//		UserSession userSession = new UserSession(
//			petStore.getAccount(accountForm.getAccount().getUsername()));
//		PagedListHolder<Product> myList = new PagedListHolder<Product>(
//			petStore.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
//		myList.setPageSize(4);
//		userSession.setMyList(myList);
//		session.setAttribute("userSession", userSession);
		return successViewName;  
	}


}
