//package com.mulcam.SpringProject.chatting.dto;
//
//import lombok.*;
//import org.springframework.web.socket.WebSocketSession;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.UUID;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ChatRoomDTO {
//	
//	private String sender;
//	private String roomId;
//	private String name;
//	
//	private Set<WebSocketSession> sessions = new HashSet<>();
//	//	스프링에서 웹소켓 커넥션이 맺어진 세션
//	
//	public static ChatRoomDTO create(String name) {
//		ChatRoomDTO room = new ChatRoomDTO();
//		
//		room.roomId = UUID.randomUUID().toString();
//		room.name = name;
//		return room;
//	}
//	
//}
