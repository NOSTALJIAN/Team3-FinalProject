package com.mulcam.SpringProject.entity;

import java.util.List;

public class MatchingUsers {
	private String uid;
	private String nickname;
	private String uImage;
	private String distance;
	private int age;
	private List<String> coincideExer;
	private String gender;
	private float uRating;
	private float score;
	
	public MatchingUsers() {}
	public MatchingUsers(String uid, String nickname, String uImage, String distance, int age, List<String> coincideExer,
			String gender, float uRating, float score) {
		super();
		this.uid = uid;
		this.nickname = nickname;
		this.uImage = uImage;
		this.distance = distance;
		this.age = age;
		this.coincideExer = coincideExer;
		this.gender = gender;
		this.uRating = uRating;
		this.score = score;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getCoincideExer() {
		return coincideExer;
	}
	public void setCoincideExer(List<String> coincideExer) {
		this.coincideExer = coincideExer;
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
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "MatchingUsers [uid=" + uid + ", nickname=" + nickname + ", uImage=" + uImage + ", distance=" + distance
				+ ", age=" + age + ", coincideExer=" + coincideExer + ", gender=" + gender + ", uRating=" + uRating
				+ ", score=" + score + "]";
	}
	
}
