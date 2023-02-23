package com.mulcam.SpringProject.entity;

import java.time.LocalDateTime;

public class BoardMate {
	private int bid;
	private String uid;
	private String receiveUser;
	private LocalDateTime sendTime;
	private int likeExercise;
	private int birthDate;
	private String gender;
	private String bTitle;
	private String nickname;
	private String uImage;
	
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
	
	public BoardMate(int bid, String uid, String receiveUser, LocalDateTime sendTime, int likeExercise, int birthDate,
			String gender, String bTitle) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.receiveUser = receiveUser;
		this.sendTime = sendTime;
		this.likeExercise = likeExercise;
		this.birthDate = birthDate;
		this.gender = gender;
		this.bTitle = bTitle;
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
	
	public int getLikeExercise() {
		return likeExercise;
	}

	public void setLikeExercise(int likeExercise) {
		this.likeExercise = likeExercise;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getuImage() {
		return uImage;
	}

	public void setuImage(String uImage) {
		this.uImage = uImage;
	}

	@Override
	public String toString() {
		return "BoardMate [bid=" + bid + ", uid=" + uid + ", receiveUser=" + receiveUser + ", sendTime=" + sendTime
				+ ", likeExercise=" + likeExercise + ", birthDate=" + birthDate + ", gender=" + gender + ", bTitle="
				+ bTitle + ", nickname=" + nickname + ", uImage=" + uImage + "]";
	}

	
}
