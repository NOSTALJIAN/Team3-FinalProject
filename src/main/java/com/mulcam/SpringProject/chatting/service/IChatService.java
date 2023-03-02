package com.mulcam.SpringProject.chatting.service;

import java.util.Map;

public interface IChatService {

	/**
	 * 	채팅 메인 페이지
	 *  해당 워크스페이스의 모든 채팅방 리스트와 워크 스페이스 멤버리스트를 리턴
	 */
	public Map<String, Object> getChatListByGroupNo(Map<String, Object> paramMap);

	/**
	 * 채팅방
	 * 채팅방 하나의 정보를 리턴 (기존 채팅 메세지 리스트, 방 이름, chatMemberNo...)
	 */
	public Map<String, Object> addChatRoom(Map<String, Object> paramMap);

	/**
	 * 채팅방 생성
	 */
	public Map<String, Object> getChatRoom(Map<String, Object> map);

	/**
	 * 채팅 메세지 저장
	 */
	public void addChatMsg(Map<String, Object> map);

}
