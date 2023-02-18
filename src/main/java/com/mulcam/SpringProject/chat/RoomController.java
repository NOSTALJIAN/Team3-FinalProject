package com.mulcam.SpringProject.chat;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class RoomController {
	
	private final ChatRoomRepository repository;
	private final AtomicInteger seq = new AtomicInteger(0);
	
	@GetMapping("/chatt")
	public String chatGet() {
		log.info("@ChatController, chat GET()");
		return "chatting/chatt";
	}
	
	@GetMapping("/sock")
	public String sock(Locale locale, Model model) {
		return "chatting/sock";
	}
	
	@GetMapping("/test")
	public String test(Locale locale, Model model) {
		return "chatting/test";
	}
	
	//	채팅방 목록 조회
	@GetMapping("/rooms")
	public String rooms(Model model) {
		model.addAttribute("rooms", repository.getChatRooms());
		return "chat/rooms.html";
	}
	
	//	채팅방 입장
	@GetMapping("/rooms/{cid}")
	public String room(@PathVariable String cid, Model model) {
		ChatRoom room = repository.getChatRoom(cid);
		model.addAttribute("room", room);
		model.addAttribute("member", "member" + seq.incrementAndGet());	//	회원 이름 부여
		return "chat/room.html";
	}
	
	//	채팅방 개설
//	@PostMapping("/room")
//	public String create(@RequestParam String uid, RedirectAttributes rttr) {
//		
//		log.info("# CREATE CHAT ROOM , name: " + uid);
//		rttr.addFlashAttribute("roomName", repository.createChatRoom(uid));
//		
//		return "redirect:/chat/rooms.html";
		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/chatting/room");
//		return mv;
//	}
	
	//	채팅방 조회
//	@GetMapping("/room")
//	public void getRoom(String cid, Model model) {
//		
//		log.info("# GET CHAT ROOM, ROOM ID : " + cid);
//		
//		model.addAttribute("room.html", repository.findRoomById(cid));
//	}
}
