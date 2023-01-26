package com.mulcam.SpringProject.entity;

public class User_info {
	private String uid;
	private int u_postcode;
	private String u_addr;
	private String u_detailAddr;
	private int like_exercise;
	private int birth_date;
	private String gender;
	private float u_rating;
	
	public User_info() {}
	public User_info(String uid, int u_postcode, String u_addr, String u_detailAddr, int like_exercise, int birth_date,
			String gender, float u_rating) {
		super();
		this.uid = uid;
		this.u_postcode = u_postcode;
		this.u_addr = u_addr;
		this.u_detailAddr = u_detailAddr;
		this.like_exercise = like_exercise;
		this.birth_date = birth_date;
		this.gender = gender;
		this.u_rating = u_rating;
	}
	public User_info(String uid, int u_postcode, String u_addr, String u_detailAddr, int like_exercise, int birth_date,
			String gender) {
		super();
		this.uid = uid;
		this.u_postcode = u_postcode;
		this.u_addr = u_addr;
		this.u_detailAddr = u_detailAddr;
		this.like_exercise = like_exercise;
		this.birth_date = birth_date;
		this.gender = gender;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getU_postcode() {
		return u_postcode;
	}

	public void setU_postcode(int u_postcode) {
		this.u_postcode = u_postcode;
	}

	public String getU_addr() {
		return u_addr;
	}

	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}

	public String getU_detailAddr() {
		return u_detailAddr;
	}

	public void setU_detailAddr(String u_detailAddr) {
		this.u_detailAddr = u_detailAddr;
	}

	public int getLike_exercise() {
		return like_exercise;
	}

	public void setLike_exercise(int like_exercise) {
		this.like_exercise = like_exercise;
	}

	public int getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(int birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getU_rating() {
		return u_rating;
	}

	public void setU_rating(float u_rating) {
		this.u_rating = u_rating;
	}

	@Override
	public String toString() {
		return "User_info [uid=" + uid + ", u_postcode=" + u_postcode + ", u_addr=" + u_addr + ", u_detailAddr="
				+ u_detailAddr + ", like_exercise=" + like_exercise + ", birth_date=" + birth_date + ", gender="
				+ gender + ", u_rating=" + u_rating + "]";
	}
	
}
