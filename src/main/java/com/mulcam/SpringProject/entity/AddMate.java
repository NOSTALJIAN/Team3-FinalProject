package com.mulcam.SpringProject.entity;

public class AddMate {
	private String uid;
	private String receiveUser;
	
	public AddMate() {}
	public AddMate(String uid, String receiveUser) {
		super();
		this.uid = uid;
		this.receiveUser = receiveUser;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getReceiveUser() {
		return receiveUser;
	}
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}
	@Override
	public String toString() {
		return "AddMate [uid=" + uid + ", receiveUser=" + receiveUser + "]";
	}
}
