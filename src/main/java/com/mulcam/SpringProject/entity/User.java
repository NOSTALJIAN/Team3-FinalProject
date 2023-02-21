package com.mulcam.SpringProject.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "users")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class User implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "uid")
	private String uid;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "uname")
	private String uname;
	
	@Column(name = "uImage")
	private String uImage;
	
	@Column(name = "phoneNum")
	private String phoneNum;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "emailCheck")
	private int emailCheck;
	
	@Column(name = "role")
	private int role;
	
	@Column(name = "uRegDate")
	private LocalDate uRegDate;
	
	@Column(name = "uisDeleted")
	private int isDeleted;
	
	public User() {}
	/** 회원정보 수정용*/
	public User(String uid, String phoneNum, String email, int emailCheck) {
		super();
		this.uid = uid;
		this.phoneNum = phoneNum;
		this.email = email;
		this.emailCheck = emailCheck;
	}
	public User(String uid, String pwd, String uname, String phoneNum, String email, int emailCheck) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.emailCheck = emailCheck;
	}
	public User(String uid, String pwd, String uname, String uImage, String phoneNum, String email, int emailCheck,
			int role, int isDeleted, LocalDate uRegDate) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.uImage = uImage;
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
		return "User [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", uImage=" + uImage + ", phoneNum="
				+ phoneNum + ", email=" + email + ", emailCheck=" + emailCheck + ", role=" + role + ", isDeleted="
				+ isDeleted + ", uRegDate=" + uRegDate + "]";
	}
	
}