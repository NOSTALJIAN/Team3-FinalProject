package com.mulcam.SpringProject.entity;

import java.time.LocalDateTime;

public class Board {

	private int bid;
	private String uid;
	private String bTitle;
	private String bCategory;
	private int bUserCount;
	private String bContent;
	private LocalDateTime bRegTime;
	private LocalDateTime bAppointment;
	private int bViewCount;
	private int bReplyCount;
	private String bLocation;
	private String bFiles;
	private int bIsDeleted;
	private String bAddr;
	
	public Board() {}
	
	public Board(int bid, String uid, String bTitle, String bCategory, int bUserCount, String bContent,
			LocalDateTime bRegTime, LocalDateTime bAppointment, int bViewCount, int bReplyCount, String bLocation,
			String bFiles, int bIsDeleted, String bAddr) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.bTitle = bTitle;
		this.bCategory = bCategory;
		this.bUserCount = bUserCount;
		this.bContent = bContent;
		this.bRegTime = bRegTime;
		this.bAppointment = bAppointment;
		this.bViewCount = bViewCount;
		this.bReplyCount = bReplyCount;
		this.bLocation = bLocation;
		this.bFiles = bFiles;
		this.bIsDeleted = bIsDeleted;
		this.bAddr = bAddr;
	}

		// 게시물 작성시 생성자
		public Board(String uid, String bTitle, String bCategory, int bUserCount, String bContent,
				LocalDateTime bAppointment, String bLocation, String bAddr, String bFiles) {
			this.uid = uid;
			this.bTitle = bTitle;
			this.bCategory = bCategory;
			this.bUserCount = bUserCount;
			this.bContent = bContent;
			this.bAppointment = bAppointment;
			this.bLocation = bLocation;
			this.bAddr = bAddr;
			this.bFiles = bFiles;
		}

	public Board(int bid, String uid, String bTitle, String bCategory, int bUserCount, String bContent,
			LocalDateTime bRegTime, LocalDateTime bAppointment, int bViewCount, int bReplyCount, String bLocation,
			String bFiles, int bIsDeleted) {
		this.bid = bid;
		this.uid = uid;
		this.bTitle = bTitle;
		this.bCategory = bCategory;
		this.bUserCount = bUserCount;
		this.bContent = bContent;
		this.bRegTime = bRegTime;
		this.bAppointment = bAppointment;
		this.bViewCount = bViewCount;
		this.bReplyCount = bReplyCount;
		this.bLocation = bLocation;
		this.bFiles = bFiles;
		this.bIsDeleted = bIsDeleted;
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

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbCategory() {
		return bCategory;
	}

	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}

	public int getbUserCount() {
		return bUserCount;
	}

	public void setbUserCount(int bUserCount) {
		this.bUserCount = bUserCount;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public LocalDateTime getbRegTime() {
		return bRegTime;
	}

	public void setbRegTime(LocalDateTime bRegTime) {
		this.bRegTime = bRegTime;
	}

	public LocalDateTime getbAppointment() {
		return bAppointment;
	}

	public void setbAppointment(LocalDateTime bAppointment) {
		this.bAppointment = bAppointment;
	}

	public int getbViewCount() {
		return bViewCount;
	}

	public void setbViewCount(int bViewCount) {
		this.bViewCount = bViewCount;
	}

	public int getbReplyCount() {
		return bReplyCount;
	}

	public void setbReplyCount(int bReplyCount) {
		this.bReplyCount = bReplyCount;
	}

	public String getbLocation() {
		return bLocation;
	}

	public void setbLocation(String bLocation) {
		this.bLocation = bLocation;
	}

	public String getbFiles() {
		return bFiles;
	}

	public void setbFiles(String bFiles) {
		this.bFiles = bFiles;
	}

	public int getbIsDeleted() {
		return bIsDeleted;
	}

	public void setbIsDeleted(int bIsDeleted) {
		this.bIsDeleted = bIsDeleted;
	}

	public String getbAddr() {
		return bAddr;
	}

	public void setbAddr(String bAddr) {
		this.bAddr = bAddr;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", uid=" + uid + ", bTitle=" + bTitle + ", bCategory=" + bCategory
				+ ", bUserCount=" + bUserCount + ", bContent=" + bContent + ", bRegTime=" + bRegTime + ", bAppointment="
				+ bAppointment + ", bViewCount=" + bViewCount + ", bReplyCount=" + bReplyCount + ", bLocation="
				+ bLocation + ", bFiles=" + bFiles + ", bIsDeleted=" + bIsDeleted + ", bAddr=" + bAddr + "]";
	}


	
	
}