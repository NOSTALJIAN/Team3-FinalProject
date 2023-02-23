package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class chatDTO {
	
	private String id;
	private String chatRoomId;
	private String memberId;
	
	private String message;
	private String region;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime regDate;
}
