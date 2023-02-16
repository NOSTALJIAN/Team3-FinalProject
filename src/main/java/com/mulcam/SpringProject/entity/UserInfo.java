package com.mulcam.SpringProject.entity;

public class UserInfo {
	private String uid;
	private int uPostcode;
	private String uAddr;
	private String uDetailAddr;
	private int likeExercise;
	private int birthDate;
	private String gender;
	private float uRating;
	private String coincideExer;
	private double uLat;
	private double uLng;
	
	public UserInfo() {}
	/** 회원가입용 */
	public UserInfo(String uid, int uPostcode, String uAddr, String uDetailAddr, int likeExercise, int birthDate,
			String gender, double uLat, double uLng) {
		this.uid = uid;
		this.uPostcode = uPostcode;
		this.uAddr = uAddr;
		this.uDetailAddr = uDetailAddr;
		this.likeExercise = likeExercise;
		this.birthDate = birthDate;
		this.gender = gender;
		this.uLat = uLat;
		this.uLng = uLng;
	}
	

	/** 사용자와 운동 목록중 하나라도 일치하는데이터 가져오기용 */
	public UserInfo(String uid, int uPostcode, String uAddr, int likeExercise, int birthDate, String gender,
			float uRating, String coincideExer, double uLat, double uLng) {
		super();
		this.uid = uid;
		this.uPostcode = uPostcode;
		this.uAddr = uAddr;
		this.likeExercise = likeExercise;
		this.birthDate = birthDate;
		this.gender = gender;
		this.uRating = uRating;
		this.coincideExer = coincideExer;
		this.uLat = uLat;
		this.uLng = uLng;
	}
	
	/** 알고리즘 계산에 필요한 사용자 정보 가져오기용*/
	public UserInfo(String uid, int likeExercise, int birthDate, String gender, float uRating, double uLat,
			double uLng) {
		super();
		this.uid = uid;
		this.likeExercise = likeExercise;
		this.birthDate = birthDate;
		this.gender = gender;
		this.uRating = uRating;
		this.uLat = uLat;
		this.uLng = uLng;
	}
	
	/** 회원 정보 수정용*/
	public UserInfo(String uid, int uPostcode, String uAddr, String uDetailAddr, int likeExercise, double uLat,
			double uLng) {
		super();
		this.uid = uid;
		this.uPostcode = uPostcode;
		this.uAddr = uAddr;
		this.uDetailAddr = uDetailAddr;
		this.likeExercise = likeExercise;
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
	public String getCoincideExer() {
		return coincideExer;
	}
	public void setCoincideExer(String coincideExer) {
		this.coincideExer = coincideExer;
	}
	public double getuLat() {
		return uLat;
	}
	public void setuLat(double uLat) {
		this.uLat = uLat;
	}
	public double getuLng() {
		return uLng;
	}
	public void setuLng(double uLng) {
		this.uLng = uLng;
	}
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", uPostcode=" + uPostcode + ", uAddr=" + uAddr + ", uDetailAddr=" + uDetailAddr
				+ ", likeExercise=" + likeExercise + ", birthDate=" + birthDate + ", gender=" + gender + ", uRating="
				+ uRating + ", coincideExer=" + coincideExer + ", uLat=" + uLat + ", uLng=" + uLng + "]";
	}
	
}