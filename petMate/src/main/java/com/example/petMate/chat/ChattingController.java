package com.example.petMate.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChattingController {
	
	@RequestMapping(value = "/chat.do", method = RequestMethod.GET)
	public String chat() {
		return "Chat";

	}

}
