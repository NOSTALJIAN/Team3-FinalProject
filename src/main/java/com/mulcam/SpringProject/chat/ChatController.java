package com.mulcam.SpringProject.chat;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/chat")
public class ChatController {
	
	@GetMapping("/chatt")
	public String chatGet() {
		log.info("@ChatController, chat GET()");
		return "chatting/chat";
	}
	
	@GetMapping("/sock")
	public String sock(Locale locale, Model model) {
		return "chatting/sock";
	}
	
	@GetMapping("/test")
	public String test(Locale locale, Model model) {
		return "chatting/test";
	}
	
	/**
	 * 방 페이지
	 * @return
	 */
	@GetMapping("/room")
	public ModelAndView room() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/chatting/room");
		return mv;
	}
	
}
