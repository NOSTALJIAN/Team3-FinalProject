package com.mulcam.SpringProject.entity;

import java.time.LocalDate;

public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String nickname;
	private String uImage;
	private String phoneNum;
	private String email;
	private int emailCheck;
	private int role;
	private int uIsDeleted;
	private LocalDate uRegDate;
	
	public User() {}
	/** 회원정보 수정용*/
	public User(String uid, String nickname, String phoneNum, String email, int emailCheck) {
		super();
		this.uid = uid;
		this.nickname = nickname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.emailCheck = emailCheck;
	}
	public User(String uid, String pwd, String uname, String nickname, String phoneNum, String email, int emailCheck) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.nickname = nickname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.emailCheck = emailCheck;
	}
	public User(String uid, String pwd, String uname, String nickname, String uImage, String phoneNum, String email,
			int emailCheck, int role, int uIsDeleted, LocalDate uRegDate) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.nickname = nickname;
		this.uImage = uImage;
		this.phoneNum = phoneNum;
		this.email = email;
		this.emailCheck = emailCheck;
		this.role = role;
		this.uIsDeleted = uIsDeleted;
		this.uRegDate = uRegDate;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmailCheck() {
		return emailCheck;
	}
	public void setEmailCheck(int emailCheck) {
		this.emailCheck = emailCheck;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getuIsDeleted() {
		return uIsDeleted;
	}
	public void setuIsDeleted(int uIsDeleted) {
		this.uIsDeleted = uIsDeleted;
	}
	public LocalDate getuRegDate() {
		return uRegDate;
	}
	public void setuRegDate(LocalDate uRegDate) {
		this.uRegDate = uRegDate;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", nickname=" + nickname + ", uImage="
				+ uImage + ", phoneNum=" + phoneNum + ", email=" + email + ", emailCheck=" + emailCheck + ", role="
				+ role + ", uIsDeleted=" + uIsDeleted + ", uRegDate=" + uRegDate + "]";
	}

	
	
}