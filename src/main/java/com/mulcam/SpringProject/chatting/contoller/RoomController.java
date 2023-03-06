package com.mulcam.SpringProject.chatting.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.SpringProject.chatting.domain.ChatMsg;
import com.mulcam.SpringProject.chatting.domain.ChatRoom;
import com.mulcam.SpringProject.chatting.service.ChatService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class RoomController {
	
	private final ChatService chatService;
	
	@GetMapping("/chatroom")
	public String chatRoom() {
		return "chat/chatroom";
	}
	
	
//	@GetMapping("/{cid}")
//	public String joinRoom(@PathVariable(required = false) int cid, Model model) {
//		List<ChatMsg> chatList = chatService.findAllChatByRoomId(cid);
//		
//		model.addAttribute("cid", cid);
//		model.addAttribute("chatList", chatList);
//		return "chat/chatroom";
//	}
	
	@PostMapping("/room")
	public String createRoom(RoomForm form) {
		chatService.createRoom(form.getName());
		return "redirect:/roomList";
	}
	
	@GetMapping("/roomList")
	public String roomList(Model model) {
		List<ChatRoom> roomList = chatService.findAllRoom();
		model.addAttribute("roomList", roomList);
		return "chat/roomList";
	}
	
	@GetMapping("/roomForm")
	public String roomForm() {
		return "chat/roomForm";
	}
}