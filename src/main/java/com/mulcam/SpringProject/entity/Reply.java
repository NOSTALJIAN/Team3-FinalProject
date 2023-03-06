package com.mulcam.SpringProject.entity;

import java.time.LocalDateTime;

public class Reply {
	private int rid;
	private int bid;
	private String uid;
	private String rContent;
	private LocalDateTime rRegTime;
	private int rIsMine;
	private String nickname;
	
	public Reply() {}
	
	/** 댓글 등록시 필요한 생성자*/
	public Reply(int bid, String uid, String rContent, int rIsMine, String nickname) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.rContent = rContent;
		this.rIsMine = rIsMine;
		this.nickname = nickname;
	}
	
	/** 댓글 수정시 필요한 생성자*/
	public Reply(int rid, String rContent) {
		super();
		this.rid = rid;
		this.rContent = rContent;
	}

	public Reply(int rid, int bid, String uid, String rContent, LocalDateTime rRegTime, int rIsMine, String nickname) {
		super();
		this.rid = rid;
		this.bid = bid;
		this.uid = uid;
		this.rContent = rContent;
		this.rRegTime = rRegTime;
		this.rIsMine = rIsMine;
		this.nickname = nickname;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public LocalDateTime getrRegTime() {
		return rRegTime;
	}

	public void setrRegTime(LocalDateTime rRegTime) {
		this.rRegTime = rRegTime;
	}

	public int getrIsMine() {
		return rIsMine;
	}

	public void setrIsMine(int rIsMine) {
		this.rIsMine = rIsMine;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", bid=" + bid + ", uid=" + uid + ", rContent=" + rContent + ", rRegTime="
				+ rRegTime + ", rIsMine=" + rIsMine + ", nickname=" + nickname + "]";
	}

}
