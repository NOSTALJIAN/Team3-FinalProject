package com.mulcam.SpringProject.chatting.entity;

import lombok.Data;

@Data
public class ChatMsg {

	private int chatMsgNo;			//	PK
	private int chatMemberNo;		//	FK
	private String chatMsg;
	private int chatReadCnt;
	private String createDate;
	
	private int chatRoomNo;
	private String option;
	private String chatMemberId;
}
