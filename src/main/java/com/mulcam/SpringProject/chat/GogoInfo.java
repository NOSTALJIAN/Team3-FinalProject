package com.mulcam.SpringProject.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class GogoInfo {

	@Autowired
	private ObjectMapper objectMapper;
	
	public ObjectNode chatRoom(ChatRoomInfoDto chatRoomInfoDto) {
		ObjectNode gogo = objectMapper.createObjectNode();
		ObjectNode item = objectMapper.valueToTree(chatRoomInfoDto);
		
		gogo.put("status", 200);
		gogo.set("item", item);
		
		return gogo;
	}
}
