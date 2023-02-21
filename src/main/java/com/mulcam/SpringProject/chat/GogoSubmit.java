package com.mulcam.SpringProject.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class GogoSubmit {
	
	private final String domainUrl = "https://localhost:8080/";
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public ObjectNode chatRoom(String cid, String roomMakerId, String guestId) {
		ObjectNode gogo = objectMapper.createObjectNode();
		ObjectNode item = objectMapper.createObjectNode();
		
		gogo.put("status", 200);
		
		item.put("cid", cid);
		item.put("roomMakerId", roomMakerId);
		item.put("guestId", guestId);
		
		gogo.set("item", item);
		return gogo;
	}
	
	public ObjectNode chatMessage(String mid) {
		ObjectNode gogo = objectMapper.createObjectNode();
		ObjectNode item = objectMapper.createObjectNode();
		
		gogo.put("status", 200);
		
		item.put("cid", mid);
		
		gogo.set("item", item);
		return gogo;
	}
}
