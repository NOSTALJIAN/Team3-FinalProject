package com.mulcam.SpringProject.entity;

import java.time.LocalDate;

public class Board {

	private int bid;
	private String uid;
	private String title;
	private String content;
	private LocalDate modTime;
	private int viewCount;
	private int replyCount;
	private int isDeleted;
	private String files;
	
	public Board() {}
	
	public Board(int bid, String uid, String title, LocalDate modTime) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.title = title;
		this.modTime = modTime;
	}

	public Board(int bid, String uid, String title, String content, LocalDate modTime) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
	}

	public Board(int bid, String uid, String title, String content, LocalDate modTime, int viewCount, int replyCount,
			int isDeleted, String files) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.isDeleted = isDeleted;
		this.files = files;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getModTime() {
		return modTime;
	}
	public void setModTime(LocalDate modTime) {
		this.modTime = modTime;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "Board [bid=" + bid + ", uid=" + uid + ", title=" + title + ", content=" + content + ", modTime="
				+ modTime + ", viewCount=" + viewCount + ", replyCount=" + replyCount + ", isDeleted=" + isDeleted
				+ ", files=" + files + "]";
	}
	
	
}
