package com.mulcam.SpringProject.chat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepository {
	
	private Map<String, ChatRoom> chatRoomMap;
	
	@PostConstruct
	private void init() {
		chatRoomMap = new LinkedHashMap<>();
	}
	
	public List<ChatRoom> findAllRooms() {
		//	채팅방 생성 순서 최근 순으로 반환
		List<ChatRoom> result = new ArrayList<>(chatRoomMap.values());
		Collections.reverse(result);
		
		return result;
	}
	
	public ChatRoom findRoomById(String uid) {
		return chatRoomMap.get(uid);
	}
	
	public ChatRoom createChatRoom(String cid) {
		ChatRoom room = ChatRoom.create(cid);
		chatRoomMap.put(room.getUid(), room);
		
		return room;
	}
	
//	public ChatRoomRepository(Collection<ChatRoom> chatRooms) {
//		chatRoomMap = Collections.unmodifiableMap(
//				Stream.of(ChatRoom.create("1번방"), ChatRoom.create("2번방"), ChatRoom.create("3번방"))
//					.collect(Collectors.toMap(ChatRoom::getCid,	Function.identity())));
//		
//		chatRooms = Collections.unmodifiableCollection(chatRoomMap.values());
//	}
//	
//	public ChatRoom getChatRoom(String cid) {
//		return chatRoomMap.get(cid);
//	}
//	
//	public Collection<ChatRoom> getChatRooms() {
//		return chatRoomMap.values();
//	}
	
}
