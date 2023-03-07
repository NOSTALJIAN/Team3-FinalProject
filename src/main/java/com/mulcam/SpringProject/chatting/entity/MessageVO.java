package com.mulcam.SpringProject.chatting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Entity
@Getter
@Setter
@ToString
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "Message")
public class MessageVO {
	
	private String room_id;
	private String mid;
	private String message;
	private String user_nickname;	//	보낸사람 닉네임
	private String user_id;			//	보낸사람 아이디
	private int unReadCount;		//	안읽은 메세지 수
	private int sessionCount;		//	현재 세션 수
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "msg_id")
//	private int mid;	//	메세지 번호
	
//	@Column
//	private int roomId;	//	방 번호
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "chatRoom_id")
//	private ChatRoomVO chatRoomVO;
	
//	@Column
//	private String sender;	//	보낸 사람
	
//	@Column
//	private String message;
	
//	@Column
//	private int unReadCount;	//	안 읽은 메세지 수
	
//	@Column
//	private int sessionCount;	//	현재 세션 수
	
//	@CreationTimestamp
//	@Column(updatable = false)
//	private LocalDateTime sendDate;
	
//	public static MessageVO toChatEntity(ChatMessageSaveDTO chatMessageSaveDTO, ChatRoomVO chatRoomVO) {
//		MessageVO messageVO = new MessageVO();
//		
//		messageVO.setChatRoomVO(chatRoomVO);
//		
//		messageVO.setSender(chatMessageSaveDTO.getSender());
//		messageVO.setMessage(chatMessageSaveDTO.getMessage());
//		
//		return messageVO;
//	}
}
