package com.mulcam.SpringProject.chat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {
	
	private String cid;
	private String uid;
	private Set<WebSocketSession> sessions = new HashSet<>();	//	Spring 에서 WebSocket Connection이 맺어진 세션
	
	public static ChatRoom create(@NonNull String uid) {
		ChatRoom created = new ChatRoom();
		
		created.cid = UUID.randomUUID().toString();
		created.uid = uid;
		return created;
	}
	
	/** 
	 * Getter, Setter
	 */
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Set<WebSocketSession> getSessions() {
		return sessions;
	}
	public void setSessions(Set<WebSocketSession> sessions) {
		this.sessions = sessions;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "ChatRoom [cid=" + cid + ", uid=" + uid + ", sessions=" + sessions + "]";
	}

}