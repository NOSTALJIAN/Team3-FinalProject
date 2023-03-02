package com.mulcam.SpringProject.chatting.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IChatRoomMapper {
	
	//	채팅방 생성
	int insertChatRoom(Map<String, Object> map);

	//	채팅방 불러오기
	List<Map<String, Object>> selectChatRoomListByJoinMemberId(Map<String, Object> map);
}
