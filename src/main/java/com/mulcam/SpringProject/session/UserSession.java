package com.mulcam.SpringProject.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession implements Serializable {
	private String uid;
	private String uname;
	private String nickname;
	private int currentBoardPage;
	private String prevPage;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCurrentBoardPage() {
		return currentBoardPage;
	}
	public void setCurrentBoardPage(int currentBoardPage) {
		this.currentBoardPage = currentBoardPage;
	}
	public String getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(String prevPage) {
		this.prevPage = prevPage;
	}
	@Override
	public String toString() {
		return "UserSession [uid=" + uid + ", uname=" + uname + ", nickname=" + nickname + ", currentBoardPage="
				+ currentBoardPage + ", prevPage=" + prevPage + "]";
	}

}
