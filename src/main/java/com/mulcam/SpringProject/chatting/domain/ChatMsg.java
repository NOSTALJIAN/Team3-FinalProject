package com.mulcam.SpringProject.chatting.domain;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.annotation.Id;

@RedisHash
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Setter
public class ChatMsg implements Message {
	
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
	
	public String timestamp;
	
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

	@Override
	public short lowestSupportedVersion() {
		
		return 0;
	}

	@Override
	public short highestSupportedVersion() {
		
		return 0;
	}

	@Override
	public void addSize(MessageSizeAccumulator size, ObjectSerializationCache cache, short version) {
	}

	@Override
	public void write(Writable writable, ObjectSerializationCache cache, short version) {
	}

	@Override
	public void read(Readable readable, short version) {
	}

	@Override
	public List<RawTaggedField> unknownTaggedFields() {
		
		return null;
	}

	@Override
	public Message duplicate() {
		
		return null;
	}
}
