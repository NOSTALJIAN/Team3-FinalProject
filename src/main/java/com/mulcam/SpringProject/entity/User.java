package com.mulcam.SpringProject.entity;

import java.time.LocalDate;

public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String phoneNum;
	private String nickname;
	private String email;
	private int email_check;
	private int role;
	private int isDeleted;
	private LocalDate u_regDate;
	
	public User() {}
	
	public User(String uid, String pwd, String uname, String phoneNum, String nickname, String email, int email_check) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.phoneNum = phoneNum;
		this.nickname = nickname;
		this.email = email;
		this.email_check = email_check;
	}

	public User(String uid, String pwd, String uname, String phoneNum, String nickname, String email, int email_check,
			int role, int isDeleted, LocalDate u_regDate) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.phoneNum = phoneNum;
		this.nickname = nickname;
		this.email = email;
		this.email_check = email_check;
		this.role = role;
		this.isDeleted = isDeleted;
		this.u_regDate = u_regDate;
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
	public int getEmail_check() {
		return email_check;
	}
	public void setEmail_check(int email_check) {
		this.email_check = email_check;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public LocalDate getU_regDate() {
		return u_regDate;
	}
	public void setU_regDate(LocalDate u_regDate) {
		this.u_regDate = u_regDate;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", phoneNum=" + phoneNum + ", nickname="
				+ nickname + ", email=" + email + ", email_check=" + email_check + ", role=" + role + ", isDeleted="
				+ isDeleted + ", u_regDate=" + u_regDate + "]";
	}
	
}
