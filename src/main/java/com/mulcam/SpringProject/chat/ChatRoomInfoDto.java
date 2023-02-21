package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class ChatRoomInfoDto {

	private String cid;
	private ChatMessage laChatMessage;
	private Set<ChatUserInfoDto> chatRoomMembers;
	private List<ChatMessageInfoDto> latestChatMessages;
	private LocalDateTime createdAt;
}
