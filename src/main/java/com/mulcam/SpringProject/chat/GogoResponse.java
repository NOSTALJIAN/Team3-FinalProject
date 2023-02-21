package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"GOGO", "createdAt"})
public class GogoResponse {
	
	@JsonProperty("GOGO")
	private ObjectNode GOGO;
	
	@JsonProperty("createdAt")
	private String createdAt;
	
	public static GogoResponse of(ObjectNode gogo) {
		String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		return new GogoResponse(gogo, createdAt);
	}
	
//	private Map<String, ChatRoom> chatRoomMap;
//	
//	@PostConstruct
//	private void init() {
//		chatRoomMap = new LinkedHashMap<>();
//	}
//	
//	public List<ChatRoom> findAllRooms() {
//		//	채팅방 생성 순서 최근 순으로 반환
//		List<ChatRoom> result = new ArrayList<>(chatRoomMap.values());
//		Collections.reverse(result);
//		
//		return result;
//	}
//	
//	public ChatRoom findRoomById(String uid) {
//		return chatRoomMap.get(uid);
//	}
//	
//	public ChatRoom createChatRoom(String cid) {
//		ChatRoom room = ChatRoom.create(cid);
//		chatRoomMap.put(room.getUid(), room);
//		
//		return room;
//	}
	
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
