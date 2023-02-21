package com.mulcam.SpringProject.chat;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatRoomListDto {

	private int page;
	private int count;
	private String reqUid;
	private List<ChatRoomInfoDto> chatRooms;
}
