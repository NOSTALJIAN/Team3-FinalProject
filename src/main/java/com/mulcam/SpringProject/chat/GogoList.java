package com.mulcam.SpringProject.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class GogoList {

	@Autowired
	private ObjectMapper objectMapper;
	
	public ObjectNode chatRoom(ChatRoomListDto chatRoomListDto) {
		
		ObjectNode gogo = objectMapper.createObjectNode();
		ObjectNode item = objectMapper.valueToTree(chatRoomListDto);
		
		gogo.put("status", 200);
		gogo.set("item", item);
		
		return gogo;
	}
}
