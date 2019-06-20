package com.example.petMate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.petMate.domain.Account;
import com.example.petMate.service.PetMateFacade;

@Controller
public class SignInController {
	private static Logger logger = LoggerFactory.getLogger(SignInController.class);

	private PetMateFacade petMate;
	
	@Autowired
	public void setPetStore(PetMateFacade petMate) {
		this.petMate = petMate;
	}

	@RequestMapping("/signin.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction, Model model) throws Exception {
		
						
		Account account = petMate.getAccount(username, password);
		
		
		if (account == null) {
			logger.info("null");
			return new ModelAndView("SignInForm", "message", new String("unvalid userInfo"));
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("u_idx", account.getU_idx());
			
			UserSession userSession = new UserSession(account);
			model.addAttribute("userSession", userSession);
			logger.info(userSession.toString());
			
			if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else 
				return new ModelAndView("index");
		}
	}

}
