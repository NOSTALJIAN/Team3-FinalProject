package com.mulcam.SpringProject.chatting.contoller;

import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.SpringProject.chatting.common.TeamColor;
import com.mulcam.SpringProject.chatting.service.IChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/chat")
public class RestChatController {

	@Autowired
	private SimpMessagingTemplate template;	//	특정 브로커로 메세지 전달
	@Autowired
	private IChatService chatService;
	
	@GetMapping("")
	public ModelAndView chat(ModelAndView mv, HttpSession session, Map<String, Object> paramMap) {
		log.debug(TeamColor.CSK + "채팅방 메인 페이지");
		
		paramMap.put("groupNo", (int)session.getAttribute("groupNo"));
		paramMap.put("joinMemberId", (String)session.getAttribute("login"));
		
		Map<String, Object> map = chatService.getChatListByGroupNo(paramMap);
		
		//	ModelAndView
		mv.setViewName("chat/chat");
		mv.addObject("chatRoomList", map.get("chatRoomList"));
		mv.addObject("joinMemberList", map.get("joinMemberList"));
		
		log.debug(TeamColor.CSK + "joinMemberList: " + map.get("joinMemberList"));
		
		return mv;
	}
	
	//	채팅방 생성
	@PostMapping("")
	public Map<String, Object> chat(HttpSession session, @RequestParam Map<String, Object> paramMap) {
		//	필요한 데이터 -> chat_room_name, groupNo(chat_room) / chat_room_no(select key로 받아오기), chat_member_id(내 아이디 - 세션, 상대 아이디) - (chat_member)
		paramMap.put("login", (String)session.getAttribute("login"));
		paramMap.put("groupNo", (int)session.getAttribute("groupNo"));
		log.debug(TeamColor.CSK + "paramMap: " + paramMap);
		
		//	이미 1:1 채팅방이 개설되어 있으면 그 채팅방을 return, 해당 유저와의 채팅방이 없을 시 새 채팅방을 만든 후 return
		Map<String, Object> chatRoom = chatService.addChatRoom(paramMap);
		log.debug(TeamColor.CSK + "chatRoom: " + chatRoom);
		
		return chatRoom;
	}
	
	//	채팅방 입장
	@GetMapping("/{chatRoomNo}")
	public Map<String, Object> getChatRoom(ModelAndView mv, @RequestParam Map<String, Object> map, @PathVariable int chatRoomNo, HttpSession session) {
		log.debug(TeamColor.CSK + "getChatRoom : " + map);
		
		map.put("groupNo", (int)session.getAttribute("groupNo"));
		map.put("chatRoomNo", chatRoomNo);
		map.put("joinMemberId", session.getAttribute("login"));
		
		log.debug(TeamColor.CSK + "getChatRoom: " + map);
		
		Map<String, Object> chatRoom = chatService.getChatRoom(map);
		log.debug(TeamColor.CSK + "chatRoom: " + chatRoom);
		
		//	없으면 insert한 뒤 return
//		log.debug(TeamColor.CSK + chatRoom);
		
		return chatRoom;
	}
	
	//	메세지 매핑
	@MessageMapping(value = "/chat/message")
	public void message(Map<String, Object> map) {
		//	message: {chatRoomNo=1, chatMsg=ㅎㅇㅎㅇ, joinMemberName=지안, chatMemberId=nostaljian}
		log.debug(TeamColor.CSK + "message:" + map);
		map.put("time", LocalDateTime.now());
		
		//	DB 저장
		chatService.addChatMsg(map);
		
		template.convertAndSend("/sub/chat/" + map.get("chatRoomNo"), map);
	}
	
	
//	//	채팅 페이지로 이동
//	@GetMapping("/chat/room")
//	public String chat() {
//		return "chatting/chatroom";
//	}
}
