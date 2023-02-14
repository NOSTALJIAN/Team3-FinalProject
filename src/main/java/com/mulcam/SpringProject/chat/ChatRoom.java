package com.mulcam.SpringProject.chat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 클래스 위에 @Entity 어노테이션 작성 후
 * 클래스 필드 위에 @Id, @Column 어노테이션 작성
 */
@Entity	//	이 클래스가 Entity라는 것을 알려줌
@Table(name = "chatroom")
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {
	
	@Id	//	Primary Key
	@GeneratedValue	//	auto_increment 역할
	private int cid;
	
	@Column	//	열
	private String uid;
	
	/** 
	 * Getter, Setter
	 */
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
		return "ChatRoom [cid=" + cid + ", uid=" + uid + "]";
	}

}