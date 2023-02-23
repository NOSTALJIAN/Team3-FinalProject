package com.mulcam.SpringProject.chat;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
//@RequestMapping("/chat/room")
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {
	
	/**
	 * 테스트용
	 */
	@GetMapping("/rooms")
	public String getRooms() {
		return "chatting/rooms";
	}
	
	@GetMapping("/room")
	public String getRoom(String chatRoomId, String nickname, Model model) {
		model.addAttribute("chatRoomId", chatRoomId);
		model.addAttribute("nickname", nickname);
		
		return "chatting/room";
	}
	
//	@GetMapping("/room")
	public ModelAndView mv(String chatRoomId, String nickname) {
		ArrayList<chatDTO> list = new ArrayList<>();
		chatDTO chat = new chatDTO(chatRoomId, nickname);
		list.add(chat);
		ModelAndView mv = new ModelAndView();
		mv.addObject("chat", chat);
		
		return mv;
	}
	
	private final ModelMapper modelMapper;
	private final ChatUserService userService;
	private final ChatRoomService chatRoomService;
	private final ChatMessageService chatMessageService;
	private final GogoSubmit submit;
	private final GogoInfo info;
	private final GogoList list;
	
	/**
	 * 	개인 채팅방 생성
	 */
	@PostMapping("/personal")
	public GogoResponse createPersonalChatRoom(@RequestParam("roomMakerId") String roomMakerId, @RequestParam("guestId") String guestId) {
		ChatUser roomMaker = userService.findById(roomMakerId);
		ChatUser guest = userService.findById(guestId);
		
		ChatRoom newRoom = ChatRoom.create();
		
		newRoom = chatRoomService.createChatRoomForPersonal(newRoom, roomMaker, guest);
		
		return GogoResponse.of(submit.chatRoom(newRoom.getId(), roomMakerId, guestId));
	}
	
	//	채팅 내역 출력
	@GetMapping("/")
	public GogoResponse ChatRoomInfo(@RequestParam("cid") String cid) {
		ChatRoom chatRoom = chatRoomService.findById(cid);
		ChatRoomInfoDto chatRoomInfoDto = modelMapper.map(chatRoom, ChatRoomInfoDto.class);
		
		List<ChatMessage> lastestChatMessages = chatMessageService.findChatMessageWithPaging(1, cid);
		List<ChatMessageInfoDto> chatMessageInfoDtos = new ArrayList<>();
		
		for (ChatMessage chatMessage : lastestChatMessages) {
			ChatMessageInfoDto info = modelMapper.map(chatMessage, ChatMessageInfoDto.class);
			
			chatMessageInfoDtos.add(info);
		}
		
		chatRoomInfoDto.setLatestChatMessages(chatMessageInfoDtos);
		return GogoResponse.of(info.chatRoom(chatRoomInfoDto));
	}
	
	//	채팅방 리스트
	@GetMapping("/list")
	public GogoResponse getChatRoomList(@RequestParam("uid") String uid) {
		int page = 1;
		List<ChatRoom> chatRooms = chatRoomService.findChatRoomsWithPaging(page, uid);
		List<ChatRoomInfoDto> chatRoomInfoDtos = new ArrayList<>();
		
		for (ChatRoom chatRoom : chatRooms) {
			ChatRoomInfoDto info = modelMapper.map(chatRoom, ChatRoomInfoDto.class);
			chatRoomInfoDtos.add(info);
		}
		
		ChatRoomListDto chatRoomListDto = ChatRoomListDto.builder()
				.page(page)
				.count(chatRooms.size())
				.reqUid(uid)
				.chatRooms(chatRoomInfoDtos)
				
				.build();
		
		return GogoResponse.of(list.chatRoom(chatRoomListDto));
	}

//	private final ChatRoomRepository repository;
////	private final AtomicInteger seq = new AtomicInteger(0);
//	
//	@GetMapping("/chatt")
//	public String chatGet() {
//		log.info("@ChatController, chat GET()");
//		return "chatting/chatt";
//	}
//	
//	@GetMapping("/sock")
//	public String sock(Locale locale, Model model) {
//		return "chatting/sock";
//	}
//	
//	@GetMapping("/test")
//	public String test(Locale locale, Model model) {
//		return "chatting/test";
//	}
//	
//	//	채팅방 목록 조회
//	@GetMapping("/rooms")
//	public ModelAndView rooms() {
//		log.info("# ALL CHAT ROOMS");
//		ModelAndView mv = new ModelAndView("chat/rooms");
//		
//		mv.addObject("list", repository.findAllRooms());
//		
//		return mv;
//	}
//	
//	//	채팅방 개설
//	@PostMapping("/room")
//	public String create(@RequestParam String name, RedirectAttributes rttr) {
//		log.info("# CREATE CHAT ROOM, NAME: " + name);
//		rttr.addFlashAttribute("roomName", repository.createChatRoom(name));
//		return "redirect:/chat/rooms";
//	}
//	
//	//	채팅방 조회
//	@GetMapping("/room")
//	public void getRoom(String uid, Model model) {
//		log.info("# GET CHAT ROOM, roomID : " + uid);
//		
//		model.addAttribute("room", repository.findRoomById(uid));
//	}
	
//		채팅방 목록 조회
//	@GetMapping("/rooms")
//	public String rooms(Model model) {
//		model.addAttribute("rooms", repository.getChatRooms());
//		return "chat/rooms.html";
//	}
//	
//	//	채팅방 입장
//	@GetMapping("/rooms/{cid}")
//	public String room(@PathVariable String cid, Model model) {
//		ChatRoom room = repository.getChatRoom(cid);
//		model.addAttribute("room", room);
//		model.addAttribute("member", "member" + seq.incrementAndGet());	//	회원 이름 부여
//		return "chat/room.html";
//	}
	
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
