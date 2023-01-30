package com.mulcam.SpringProject.entity;

import java.time.LocalDate;

public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String phoneNum;
	private String nickname;
	private String email;
	private int emailcheck;
	private int role;
	private int uIsDeleted;
	private LocalDate uRegDate;
	
	public User() {}

	public User(String uid, String pwd, String uname, String phoneNum, String nickname, String email, int emailcheck,
			int role, int uIsDeleted, LocalDate uRegDate) {
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.phoneNum = phoneNum;
		this.nickname = nickname;
		this.email = email;
		this.emailcheck = emailcheck;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmailcheck() {
		return emailcheck;
	}

	public void setEmailcheck(int emailcheck) {
		this.emailcheck = emailcheck;
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
		return "User [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", phoneNum=" + phoneNum + ", nickname="
				+ nickname + ", email=" + email + ", emailcheck=" + emailcheck + ", role=" + role + ", uIsDeleted="
				+ uIsDeleted + ", uRegDate=" + uRegDate + "]";
	}
	
	
}
