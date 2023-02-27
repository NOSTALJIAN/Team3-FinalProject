package com.mulcam.SpringProject.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Mate {
	private String uid;
	private String receiveUser;
	private LocalDateTime sendTime;
	private String nickname;
	private String uImage;
	private List<String> likeExerList;
	private String gender;
	private int age;
	
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
	// 친구추가/수락창에서 DB에서 관심운동제외하고 데이터 가져오기용도
	public Mate(String uid, String receiveUser, LocalDateTime sendTime, String nickname, String uImage, String gender,
			int age) {
		super();
		this.uid = uid;
		this.receiveUser = receiveUser;
		this.sendTime = sendTime;
		this.nickname = nickname;
		this.uImage = uImage;
		this.gender = gender;
		this.age = age;
	}
	// 친구추가/수락창에서 관심운동 추가한뒤에 jsp에 데이터 뿌리는용도 
	public Mate(String uid, String receiveUser, LocalDateTime sendTime, String nickname, String uImage,
			List<String> likeExerList, String gender, int age) {
		super();
		this.uid = uid;
		this.receiveUser = receiveUser;
		this.sendTime = sendTime;
		this.nickname = nickname;
		this.uImage = uImage;
		this.likeExerList = likeExerList;
		this.gender = gender;
		this.age = age;
	}
	// 현재 친구상태인친구들 DB에서 데이터 가져오는용도
	public Mate(String uid, String receiveUser, String nickname, String uImage, String gender, int age) {
		super();
		this.uid = uid;
		this.receiveUser = receiveUser;
		this.nickname = nickname;
		this.uImage = uImage;
		this.gender = gender;
		this.age = age;
	}
	// 친구창에 관심운동 추가한뒤에 jsp에 데이터 뿌리는 용도
	public Mate(String uid, String receiveUser, String nickname, String uImage, List<String> likeExerList,
			String gender, int age) {
		super();
		this.uid = uid;
		this.receiveUser = receiveUser;
		this.nickname = nickname;
		this.uImage = uImage;
		this.likeExerList = likeExerList;
		this.gender = gender;
		this.age = age;
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
	public List<String> getLikeExerList() {
		return likeExerList;
	}
	public void setLikeExerList(List<String> likeExerList) {
		this.likeExerList = likeExerList;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Mate [uid=" + uid + ", receiveUser=" + receiveUser + ", sendTime=" + sendTime + ", nickname=" + nickname
				+ ", uImage=" + uImage + ", likeExerList=" + likeExerList + ", gender=" + gender + ", age=" + age + "]";
	}
}
