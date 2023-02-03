package com.mulcam.SpringProject.entity;

import java.time.LocalDate;

public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String phoneNum;
	private String email;
	private int emailCheck;
	private int role;
	private int isDeleted;
	private LocalDate uRegDate;
	
	public User() {}
	
	public User(String uid, String pwd, String uname, String phoneNum, String email, int emailCheck) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.emailCheck = emailCheck;
	}
	

	public User(String uid, String pwd, String uname, String phoneNum, String email, int emailCheck, int role,
			int isDeleted, LocalDate uRegDate) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.emailCheck = emailCheck;
		this.role = role;
		this.isDeleted = isDeleted;
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
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public LocalDate getuRegDate() {
		return uRegDate;
	}
	public void setuRegDate(LocalDate uRegDate) {
		this.uRegDate = uRegDate;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", phoneNum=" + phoneNum + ", email=" + email
				+ ", emailCheck=" + emailCheck + ", role=" + role + ", isDeleted=" + isDeleted + ", uRegDate="
				+ uRegDate + "]";
	}
	
}