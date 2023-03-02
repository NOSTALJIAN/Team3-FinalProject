package com.mulcam.SpringProject.chatting.entity;

import lombok.Data;

@Data
public class ChatRoom {
	private int chatRoomNo;			//	PK
	private String chatRoomName;
	private String createDate;
	private String updateDate;
	private int groupNo;

}
