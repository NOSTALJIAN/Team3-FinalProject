package com.mulcam.SpringProject.chat;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepository {
	
	private Map<String, ChatRoom> chatRoomMap;
	
	public ChatRoomRepository(Collection<ChatRoom> chatRooms) {
		chatRoomMap = Collections.unmodifiableMap(
				Stream.of(ChatRoom.create("1번방"), ChatRoom.create("2번방"), ChatRoom.create("3번방"))
					.collect(Collectors.toMap(ChatRoom::getCid,	Function.identity())));
		
		chatRooms = Collections.unmodifiableCollection(chatRoomMap.values());
	}
	
	public ChatRoom getChatRoom(String cid) {
		return chatRoomMap.get(cid);
	}
	
	public Collection<ChatRoom> getChatRooms() {
		return chatRoomMap.values();
	}
	
}
