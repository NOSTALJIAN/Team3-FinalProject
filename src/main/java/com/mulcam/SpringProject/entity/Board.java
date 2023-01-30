package com.mulcam.SpringProject.entity;

import java.time.LocalDateTime;

public class Board {

	private int bid;
	private String uid;
	private String b_title;
	private String b_category;
	private int b_userCount;
	private String b_content;
	private LocalDateTime b_regTime;
	private LocalDateTime b_appointment;
	private int b_viewCount;
	private int b_replyCount;
	private String b_location;
	private String b_files;
	private int b_isDeleted;
	
	public Board() {}

	//게시글 작성시 생성자
	public Board(String uid, String b_title, String b_category, int b_userCount, String b_content,
			LocalDateTime b_appointment, String b_location, String b_files) {
		super();
		this.uid = uid;
		this.b_title = b_title;
		this.b_category = b_category;
		this.b_userCount = b_userCount;
		this.b_content = b_content;
		this.b_appointment = b_appointment;
		this.b_location = b_location;
		this.b_files = b_files;
	}
	
	
	public Board(int bid, String uid, String b_title, String b_category, int b_userCount, String b_content,
			LocalDateTime b_regTime, LocalDateTime b_appointment, int b_viewCount, int b_replyCount, String b_location,
			String b_files, int b_isDeleted) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.b_title = b_title;
		this.b_category = b_category;
		this.b_userCount = b_userCount;
		this.b_content = b_content;
		this.b_regTime = b_regTime;
		this.b_appointment = b_appointment;
		this.b_viewCount = b_viewCount;
		this.b_replyCount = b_replyCount;
		this.b_location = b_location;
		this.b_files = b_files;
		this.b_isDeleted = b_isDeleted;
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

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public int getB_userCount() {
		return b_userCount;
	}

	public void setB_userCount(int b_userCount) {
		this.b_userCount = b_userCount;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public LocalDateTime getB_regTime() {
		return b_regTime;
	}

	public void setB_regTime(LocalDateTime b_regTime) {
		this.b_regTime = b_regTime;
	}

	public LocalDateTime getB_appointment() {
		return b_appointment;
	}

	public void setB_appointment(LocalDateTime b_appointment) {
		this.b_appointment = b_appointment;
	}

	public int getB_viewCount() {
		return b_viewCount;
	}

	public void setB_viewCount(int b_viewCount) {
		this.b_viewCount = b_viewCount;
	}

	public int getB_replyCount() {
		return b_replyCount;
	}

	public void setB_replyCount(int b_replyCount) {
		this.b_replyCount = b_replyCount;
	}

	public String getB_location() {
		return b_location;
	}

	public void setB_location(String b_location) {
		this.b_location = b_location;
	}

	public String getB_files() {
		return b_files;
	}

	public void setB_files(String b_files) {
		this.b_files = b_files;
	}

	public int getB_isDeleted() {
		return b_isDeleted;
	}

	public void setB_isDeleted(int b_isDeleted) {
		this.b_isDeleted = b_isDeleted;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", uid=" + uid + ", b_title=" + b_title + ", b_category=" + b_category
				+ ", b_userCount=" + b_userCount + ", b_content=" + b_content + ", b_regTime=" + b_regTime
				+ ", b_appointment=" + b_appointment + ", b_viewCount=" + b_viewCount + ", b_replyCount=" + b_replyCount
				+ ", b_location=" + b_location + ", b_files=" + b_files + ", b_isDeleted=" + b_isDeleted + "]";
	}
	
	
}