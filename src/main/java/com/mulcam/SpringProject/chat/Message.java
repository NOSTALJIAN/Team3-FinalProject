package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message")
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	@Id
	@GeneratedValue
	private int mid;
	
	@Column
	private String mSender;
	
	@Column
	private String mReceiver;

	@Column
	private String mContent;
	
	@Column
	private LocalDateTime mSendTime;
	
	@Column
	private LocalDateTime mRegTime;
	
	@Column
	private int cid;
	
	@Column
	private String uid;
	
	/**
	 * Getter, Setter
	 */
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getmSender() {
		return mSender;
	}
	public void setmSender(String mSender) {
		this.mSender = mSender;
	}
	public String getmReceiver() {
		return mReceiver;
	}
	public void setmReceiver(String mReceiver) {
		this.mReceiver = mReceiver;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public LocalDateTime getmSendTime() {
		return mSendTime;
	}
	public void setmSendTime(LocalDateTime mSendTime) {
		this.mSendTime = mSendTime;
	}
	public LocalDateTime getmRegTime() {
		return mRegTime;
	}
	public void setmRegTime(LocalDateTime mRegTime) {
		this.mRegTime = mRegTime;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", mSender=" + mSender + ", mReceiver=" + mReceiver + ", mContent=" + mContent
				+ ", mSendTime=" + mSendTime + ", mRegTime=" + mRegTime + ", cid=" + cid + ", uid=" + uid + "]";
	}
	
}
