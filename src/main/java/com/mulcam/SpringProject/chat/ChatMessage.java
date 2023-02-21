package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ChatMessage")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mid")
	private int mid;
	
	@JoinColumn(name = "cid", insertable = false, updatable = false)
	private String cid;
	
	@JoinColumn(name = "uid", insertable = false, updatable = false)
	private String uid;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "createAt")
	private LocalDateTime createdAt;
}