package com.mulcam.SpringProject.entity;

import java.time.LocalDateTime;

public class BoardMate {
	private int bid;
	private String uid;
	private String receiveUser;
	private LocalDateTime sendTime;
	
	public BoardMate() {}
	
	/** 참가신청시 필요한 생성자 */
	public BoardMate(int bid, String uid, String receiveUser) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.receiveUser = receiveUser;
	}

	public BoardMate(int bid, String uid, String receiveUser, LocalDateTime sendTime) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.receiveUser = receiveUser;
		this.sendTime = sendTime;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
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
		return "BoardMate [bid=" + bid + ", uid=" + uid + ", receiveUser=" + receiveUser + ", sendTime=" + sendTime
				+ "]";
	}
	
}
