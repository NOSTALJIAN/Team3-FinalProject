//package com.mulcam.SpringProject.chatting.controller;
//
//import java.util.List;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//import com.mulcam.SpringProject.chatting.dto.ChatMessageDetailDTO;
//import com.mulcam.SpringProject.chatting.dto.ChatMessageSaveDTO;
//import com.mulcam.SpringProject.chatting.entity.ChatMessageEntity;
//import com.mulcam.SpringProject.chatting.entity.ChatRoomEntity;
//import com.mulcam.SpringProject.chatting.repository.ChatRepository;
//import com.mulcam.SpringProject.chatting.repository.ChatRoomRepository;
//import com.mulcam.SpringProject.chatting.service.ChatService;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//public class StompChatController {
//	
//	private final SimpMessagingTemplate template;
////	private final KafkaTemplate<K, V>
//	
//	private final ChatRepository cr;
//	private final ChatRoomRepository crr;
//	private final ChatService cs;
//	
//	@MessageMapping("/chat/enter")
//	public void enter(ChatMessageDetailDTO message) {
//		message.setMessage(message.getSender() + "님이 채팅방에 입장하셨습니다.");
//		
//		List<ChatMessageDetailDTO> chatList = cs.findAllChatByRoomId(message.getRoomId());
//		if (chatList != null) {
//			for (ChatMessageDetailDTO c : chatList) {
//				message.setSender(c.getSender());
//				message.setMessage(c.getMessage());
//			}
//		}
//		
//		template.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
//		
//		ChatRoomEntity chatRoomEntity = crr.findByRoomId(message.getRoomId());
//		ChatMessageSaveDTO chatMessageSaveDTO = new ChatMessageSaveDTO(message.getRoomId(), message.getSender(), message.getMessage());
//		cr.save(ChatMessageEntity.toChatEntity(chatMessageSaveDTO, chatRoomEntity));
//	}
//	
//	@MessageMapping("/chat/message")
//	public void message(ChatMessageDetailDTO message) {
//		template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//		
//		ChatRoomEntity chatRoomEntity = crr.findByRoomId(message.getRoomId());
//		ChatMessageSaveDTO chatMessageSaveDTO = new ChatMessageSaveDTO(message.getRoomId(), message.getSender(), message.getMessage());
//		cr.save(ChatMessageEntity.toChatEntity(chatMessageSaveDTO, chatRoomEntity));
//	}
//}
