package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChatMessageInfoDto {
	
	private String mid;
	private String uid;
	private String message;
	private LocalDateTime createdAt;
}
