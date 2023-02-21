package com.mulcam.SpringProject.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.mulcam.SpringProject.entity.User;

@Data
@Entity
@Table(name = "ChatRoom")
@DynamicUpdate
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id")
	private String id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "lastChatMesgId")
	private ChatMessage lastChatMesg;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ChatRoom_Members", 
			joinColumns = @JoinColumn(name = "chatRoomId"), 
			inverseJoinColumns = @JoinColumn(name = "memberId"))
	private final Set<ChatUser> chatRoomMembers = new HashSet<>();
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	public static ChatRoom create() {
		ChatRoom room = new ChatRoom();
		room.setId(UUID.randomUUID().toString());
		return room;
	}
	
	public void addMembers(ChatUser roomMaker, ChatUser guest) {
		this.chatRoomMembers.add(roomMaker);
		this.chatRoomMembers.add(guest);
	}
	
//	private Set<WebSocketSession> sessions = new HashSet<>();	//	Spring 에서 WebSocket Connection이 맺어진 세션
	
//	public static ChatRoom create(@NonNull String uid) {
//		ChatRoom created = new ChatRoom();
//		
//		created.cid = UUID.randomUUID().toString();
//		created.uid = uid;
//		return created;
//	}

}