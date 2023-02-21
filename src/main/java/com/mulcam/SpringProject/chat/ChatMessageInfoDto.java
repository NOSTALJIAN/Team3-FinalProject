package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChatMessageInfoDto {
	
	private String chatMessageId;
	private String authorId;
	private String message;
	private LocalDateTime createdAt;
}
