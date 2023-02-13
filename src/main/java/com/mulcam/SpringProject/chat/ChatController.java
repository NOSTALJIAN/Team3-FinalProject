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
	
	List<Chat> chatList = new ArrayList<>();
	static int mNumber = 0;
	
	@GetMapping("/test")
	public String test(Locale locale, Model model) {
		System.out.println("chat test");
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
	
	/**
	 * 방 정보 가져오기
	 * @param params
	 * @return
	 */
	@GetMapping("/createRoom")
	public @ResponseBody List<Chat> createRoom(@RequestParam HashMap<Object, Object> params) {
		String mTitle = (String) params.get("mTitle");
		if (mTitle != null && !mTitle.trim().equals("")) {
			Chat chat = new Chat();
			chat.setmNumber(++mNumber);
			chat.setmTitle(mTitle);
			chatList.add(chat);
		}
		return chatList;
	}
	
	/**
	 * 채팅방
	 * @param params
	 * @return
	 */
	@GetMapping("/moveChatting")
	public ModelAndView chatting(@RequestParam HashMap<Object, Object> params) {
		ModelAndView mv = new ModelAndView();
		int mNumber = Integer.parseInt((String) params.get("mNumber"));
		
		List<Chat> new_list = chatList.stream().filter(o -> o.getmNumber() == mNumber).collect(Collectors.toList());
		if  (new_list != null && new_list.size() > 0) {
			mv.addObject("mTitle", params.get("mTitle"));
			mv.addObject("mNumber", params.get("mNumber"));
			mv.setViewName("/chatting/test");
		} else {
			mv.setViewName("/chatting/room");
		}
		return mv;
	}
}
