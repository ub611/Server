package com.example.petMate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignOutController {
	
	@RequestMapping("/signoff.do")
	public String handleRequest(HttpSession session) throws Exception {
		session.removeAttribute("u_idx");
		session.invalidate();
		
		return "index";
	}
}
