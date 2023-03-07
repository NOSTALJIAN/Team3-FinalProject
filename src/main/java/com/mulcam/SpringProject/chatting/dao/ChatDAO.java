package com.mulcam.SpringProject.chatting.dao;


import java.util.List;

import com.mulcam.SpringProject.chatting.entity.ChatRoomVO;
import com.mulcam.SpringProject.chatting.entity.MessageVO;

public interface ChatDAO {
	
	  //방번호로 채팅방보기
	  public ChatRoomVO selectChatRoom(String room_id);
	  
	  //메세지 저장
	  public int insertMessage(MessageVO chatMessage);
	   
	  //메세지내용 출력
	  public List<MessageVO> messageList(String room_id);
	 
	  //채팅 방 DB저장
	  public int createChat(ChatRoomVO room);
	 
	  //채팅방 찾기
	  public ChatRoomVO searchChatRoom(ChatRoomVO room);
	 
	  //채팅방 리스트 출력
	  public List<ChatRoomVO> chatRoomList(String user_id);
	    
	  //읽은 메세지 1으로바꾸기 
	  public int selectUnReadCount(MessageVO message);
	 
	  //읽은 메세지 0으로 바꾸기
	  public int updateCount(MessageVO message);
	  
	  public void deleteRoom(String room_id);
}
