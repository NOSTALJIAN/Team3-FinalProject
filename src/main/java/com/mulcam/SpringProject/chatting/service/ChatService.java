package com.mulcam.SpringProject.chatting.service;

import java.util.List;

import com.mulcam.SpringProject.chatting.entity.ChatRoomVO;
import com.mulcam.SpringProject.chatting.entity.MessageVO;


public interface ChatService {

	/** 방 번호를 선택하는 메소드 */
	ChatRoomVO selectChatRoom(String roomId);

	/** 채팅 메세지 DB 저장 */
	int insertMessage(MessageVO chatMessage);

	/** 메세지 내용 리스트 출력 */
	List<MessageVO> messageList(String roomId);

	/** 채팅 방 DB 저장 */
	int createChat(ChatRoomVO room);

	/** DB에 채팅 방이 있는지 확인 */
	ChatRoomVO searchChatRoom(ChatRoomVO room);

	/** 채팅 방 리스트 출력 */
	List<ChatRoomVO> chatRoomList(String userEmail);

	/** 채팅 읽지 않은 메세지 수 출력 */
	int selectUnReadCount(MessageVO message);

	/** 읽은 메세지 숫자 0으로 바꾸기 */
	int updateCount(MessageVO message);

    /** 방, 메세지삭제 */
    void deleteRoom(String roomId);
	
}
