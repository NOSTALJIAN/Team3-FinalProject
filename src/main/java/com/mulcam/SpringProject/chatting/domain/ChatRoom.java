package com.mulcam.SpringProject.chatting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom {
	
	@Id
	@GeneratedValue
	@Column(name = "chat_room_id")
	private int cid;
	private String uid;

	@Builder
	public ChatRoom(String uid) {
		this.uid = uid;
	}
	
	/**
	 * 채팅방 생성
	 * @param name 방 아이디
	 * @return chatRoom Entity
	 */
	public static ChatRoom createChatRoom(String uid) {
		return ChatRoom.builder()
				.uid(uid)
				.build();
	}
}
