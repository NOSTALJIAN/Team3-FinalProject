package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Chat {
	
	private String sendUserId;
	private String recieveUserId;
	private String mTitle;
	private String mContent;
	private LocalDateTime mRegTime;
	private int mConfirm;
	private int mNumber;

	/** Getter, Setter */
	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getRecieveUserId() {
		return recieveUserId;
	}

	public void setRecieveUserId(String recieveUserId) {
		this.recieveUserId = recieveUserId;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public LocalDateTime getmRegTime() {
		return mRegTime;
	}

	public void setmRegTime(LocalDateTime mRegTime) {
		this.mRegTime = mRegTime;
	}

	public int getmConfirm() {
		return mConfirm;
	}

	public void setmConfirm(int mConfirm) {
		this.mConfirm = mConfirm;
	}

	public int getmNumber() {
		return mNumber;
	}

	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
	}

	@Override
	public String toString() {
		return "Chat [sendUserId=" + sendUserId + ", recieveUserId=" + recieveUserId + ", mTitle=" + mTitle
				+ ", mContent=" + mContent + ", mRegTime=" + mRegTime + ", mConfirm=" + mConfirm + ", mNumber="
				+ mNumber + "]";
	}
}
