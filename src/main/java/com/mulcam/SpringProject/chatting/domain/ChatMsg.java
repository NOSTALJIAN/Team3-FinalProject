package com.mulcam.SpringProject.chatting.domain;

import lombok.*;
import java.time.LocalDateTime;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.annotation.Id;

@RedisHash
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ChatMsg {
	
	@Column(name = "chat_msg_id")
	@GeneratedValue
	@Id
	private int mid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chat_room_id")
	private ChatRoom chatRoom;
	
	private String sender;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime sendDate;
	
	@Builder
	public ChatMsg(ChatRoom chatRoom, String sender, String content) {
		this.chatRoom = chatRoom;
		this.sender = sender;
		this.content = content;
		this.sendDate = LocalDateTime.now();
	}
	
	/**
	 * 채팅 생성
	 * @param chatRoom 채팅방
	 * @param sender 보낸 사람
	 * @param content 내용
	 * @return ChatMsg Entity
	 */
	public static ChatMsg createChatMsg(ChatRoom chatRoom, String sender, String content) {
		return ChatMsg.builder()
				.chatRoom(chatRoom)
				.sender(sender)
				.content(content)
				.build();
	}
}
