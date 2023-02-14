package com.mulcam.SpringProject.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/chat")
public class ChatController {
	
	List<ChatRoom> chatList = new ArrayList<>();
	static int mNumber = 0;
	
	@GetMapping("/test")
	public String test(Locale locale, Model model) {
//		System.out.println("chat test");
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
