package com.mulcam.SpringProject.chatting.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mulcam.SpringProject.chatting.entity.ChatMember;

@Mapper
public interface IChatMemberMapper {
	// 채팅 멤버 추가하기
	int insertChatMember(ChatMember chatMember);
	
	// email과 chatRoomNo를 통해 chatMemberNo를 리턴
	Integer selectJoinMemberOne(Map<String, Object> paramMap);
	
	// 기존 1:1 채팅방이 있는지 리턴하는 메소드
	Integer selectChatRoomNoByJoinMemberId(Map<String, Object> paramMap);

	Map<String, Object> selectJoinMemberOne(int parseInt);

}