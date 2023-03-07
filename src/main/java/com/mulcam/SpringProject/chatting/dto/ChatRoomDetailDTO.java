//package com.mulcam.SpringProject.chatting.dto;
//
//import com.mulcam.SpringProject.chatting.entity.ChatRoomEntity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ChatRoomDetailDTO {
//
//	private Long chatRoomId;
//	private String sender;
//	private String roomId;
//	private String name;
//	
//	public static ChatRoomDetailDTO toChatRoomDetailDTO(ChatRoomEntity chatRoomEntity) {
//		ChatRoomDetailDTO chatRoomDetailDTO = new ChatRoomDetailDTO();
//		
//		chatRoomDetailDTO.setChatRoomId(chatRoomEntity.getId());
//		chatRoomDetailDTO.setSender(chatRoomEntity.getSender());
//		chatRoomDetailDTO.setRoomId(chatRoomEntity.getRoomId());
//		chatRoomDetailDTO.setName(chatRoomEntity.getRoomName());
//		
//		return chatRoomDetailDTO;
//	}
//}
