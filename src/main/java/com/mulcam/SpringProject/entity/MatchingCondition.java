package com.mulcam.SpringProject.entity;

public class MatchingCondition {
	private String uid;
	private String bestExercise;
	private int minAge;
	private int maxAge;
	private int minDistance;
	private int maxDistance;
	private String pGender;
	
	public MatchingCondition() {}
	public MatchingCondition(String uid, String bestExercise, int minAge, int maxAge, int minDistance, int maxDistance,
			String pGender) {
		this.uid = uid;
		this.bestExercise = bestExercise;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.minDistance = minDistance;
		this.maxDistance = maxDistance;
		this.pGender = pGender;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBestExercise() {
		return bestExercise;
	}
	public void setBestExercise(String bestExercise) {
		this.bestExercise = bestExercise;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public int getMinDistance() {
		return minDistance;
	}
	public void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}
	public int getMaxDistance() {
		return maxDistance;
	}
	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}
	public String getpGender() {
		return pGender;
	}
	public void setpGender(String pGender) {
		this.pGender = pGender;
	}
	@Override
	public String toString() {
		return "MatchingCondition [uid=" + uid + ", bestExercise=" + bestExercise + ", minAge=" + minAge + ", maxAge="
				+ maxAge + ", minDistance=" + minDistance + ", maxDistance=" + maxDistance + ", pGender=" + pGender
				+ "]";
	}
	
}
