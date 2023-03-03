package com.mulcam.SpringProject.chatting.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
	
	private int cid;
	private String sender;
	private String content;
	private LocalDateTime sendDate;
}
