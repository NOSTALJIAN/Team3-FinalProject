package com.mulcam.SpringProject.chatting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
//@Entity
@Component
@ToString
//@Table(name = "chatRoom")
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomVO {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "chatRoom_id")
	private String room_id;				//	방 번호
	
	private String user_id;				//	사용자 아이디
	private String user_nickname;		//	사용자 닉네임
	private String user_pic;			//	사용자 사진
	private String another_id;			//	상대방 아이디
	private String another_nickname;	//	상대방 닉네임
	private String another_pic;			//	상대방 사진
	private int unReadCount;			//	안 읽은 메세지 수
	
//	@Column
//	private String sender;
	
//	@Column
//	private String receiver;
	
//	@Column
//	private String roomName;
	
//	@Column
//	private int unReadCount;
	
//    @OneToMany(mappedBy = "MessageVO", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<MessageVO> MessageList = new ArrayList<>();
	
//    public static ChatRoomVO toChatRoomEntity(String roomName, int id, String sender) {
//    	ChatRoomVO chatRoomVO = new ChatRoomVO();
//    	chatRoomVO.setRoomName(roomName);
//    	chatRoomVO.setId(id);
//    	chatRoomVO.setSender(sender);
//		return chatRoomVO;
//	}
}
