package com.mulcam.SpringProject.entity;

import java.time.LocalDateTime;

public class Mate {
	private String uid;
	private String receiveUser;
	private LocalDateTime sendTime;
	
	public Mate() {}
	public Mate(String uid) {
		super();
		this.uid = uid;
	}
	public Mate(String uid, String receiveUser) {
		super();
		this.uid = uid;
		this.receiveUser = receiveUser;
	}
	public Mate(String uid, String receiveUser, LocalDateTime sendTime) {
		super();
		this.uid = uid;
		this.receiveUser = receiveUser;
		this.sendTime = sendTime;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getReceiveUser() {
		return receiveUser;
	}
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}
	public LocalDateTime getSendTime() {
		return sendTime;
	}
	public void setSendTime(LocalDateTime sendTime) {
		this.sendTime = sendTime;
	}
	@Override
	public String toString() {
		return "Mate [uid=" + uid + ", receiveUser=" + receiveUser + ", sendTime=" + sendTime + "]";
	}

	
	
	
}
