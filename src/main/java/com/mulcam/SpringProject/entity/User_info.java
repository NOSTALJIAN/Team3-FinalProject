package com.mulcam.SpringProject.entity;

public class User_info {
	private String uid;
	private int uPostcode;
	private String uAddr;
	private String uDetailAddr;
	private int likeExercise;
	private int birthDate;
	private String gender;
	private float uRating;
	private float uLat;
	private float uLng;
	
	public User_info() {}

	public User_info(String uid, int uPostcode, String uAddr, String uDetailAddr, int likeExercise, int birthDate,
			String gender, float uRating, float uLat, float uLng) {
		this.uid = uid;
		this.uPostcode = uPostcode;
		this.uAddr = uAddr;
		this.uDetailAddr = uDetailAddr;
		this.likeExercise = likeExercise;
		this.birthDate = birthDate;
		this.gender = gender;
		this.uRating = uRating;
		this.uLat = uLat;
		this.uLng = uLng;
	}


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getuPostcode() {
		return uPostcode;
	}

	public void setuPostcode(int uPostcode) {
		this.uPostcode = uPostcode;
	}

	public String getuAddr() {
		return uAddr;
	}

	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}

	public String getuDetailAddr() {
		return uDetailAddr;
	}

	public void setuDetailAddr(String uDetailAddr) {
		this.uDetailAddr = uDetailAddr;
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

	public float getuRating() {
		return uRating;
	}

	public void setuRating(float uRating) {
		this.uRating = uRating;
	}

	public float getuLat() {
		return uLat;
	}

	public void setuLat(float uLat) {
		this.uLat = uLat;
	}

	public float getuLng() {
		return uLng;
	}

	public void setuLng(float uLng) {
		this.uLng = uLng;
	}

	@Override
	public String toString() {
		return "User_info [uid=" + uid + ", uPostcode=" + uPostcode + ", uAddr=" + uAddr + ", uDetailAddr="
				+ uDetailAddr + ", likeExercise=" + likeExercise + ", birthDate=" + birthDate + ", gender=" + gender
				+ ", uRating=" + uRating + ", uLat=" + uLat + ", uLng=" + uLng + "]";
	}
	
	
}
