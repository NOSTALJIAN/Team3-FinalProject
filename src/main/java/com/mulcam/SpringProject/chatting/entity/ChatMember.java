package com.mulcam.SpringProject.chatting.entity;

import lombok.Data;

@Data
public class ChatMember {
	
	private int chatMemberNo;
	private int chatRoomNo;
	private String chatMemberId;
	private String createDate;
	private String updateDate;

}
