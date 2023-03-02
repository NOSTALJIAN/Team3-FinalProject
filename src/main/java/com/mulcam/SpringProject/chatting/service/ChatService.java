package com.mulcam.SpringProject.chatting.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.chatting.common.TeamColor;
import com.mulcam.SpringProject.chatting.entity.ChatMember;
import com.mulcam.SpringProject.chatting.mapper.IChatMemberMapper;
import com.mulcam.SpringProject.chatting.mapper.IChatMsgMapper;
import com.mulcam.SpringProject.chatting.mapper.IChatRoomMapper;
import com.mulcam.SpringProject.chatting.mapper.IProjectSummaryMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatService implements IChatService {
	
	@Autowired
	IProjectSummaryMapper projectSummaryMapper;
	@Autowired
	IChatRoomMapper chatRoomMapper;
	@Autowired
	IChatMemberMapper chatMemberMapper;
	@Autowired
	IChatMsgMapper chatMsgMapper;
	
	/**
	 * 채팅방 리스트 및 채팅방을 생성할 수 있는 그룹 멤버 리스트
	 */
	@Override
	public Map<String, Object> getChatListByGroupNo(Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("chatRoomList", chatRoomMapper.selectChatRoomListByJoinMemberId(paramMap));
		
		log.debug(TeamColor.CSK + "chatRoomList" + map.get("chatRoomList"));
		map.put("joinMemberList", projectSummaryMapper.selectJoinMemberListWithProfileImgByGroupNo((int)paramMap.get("groupNo")));
		
		return map;
	}

	/**
	 * 채팅방 만들기, 채팅 상대의 정보 불러오기
	 */
	@Override
	@Transactional
	public Map<String, Object> addChatRoom(Map<String, Object> paramMap) {
		Map<String, Object> chatMember = chatMemberMapper.selectJoinMemberOne(Integer.parseInt((String)paramMap.get("chatMemberNo")));
		log.debug(TeamColor.CSK + "chatMember: " + chatMember);
		
		paramMap.put("joinMemberId", chatMember.get("chatMemberId"));
		log.debug(TeamColor.CSK + "paramMap: " + paramMap);
		
		//	기존 채팅방이 존재하는지 확인
		Integer chatRoomNo = chatMemberMapper.selectChatRoomNoByJoinMemberId(paramMap);
		log.debug(TeamColor.CSK + "chatRoomNo: " + chatRoomNo);
		
		//	기존 채팅방이 존재하면
		if(chatRoomNo != null) {
			paramMap.put("chatRoomNo", chatRoomNo);
			paramMap.put("insert", "");
			return paramMap;
		}
		
		//	멀티
		paramMap.put("chatRoomName", chatMember.get("chatMemberName"));
		paramMap.put("groupNo", chatMember.get("groupNo"));
		
		//	채팅방 생성
		chatRoomMapper.insertChatRoom(paramMap);
		log.debug(TeamColor.CSK + paramMap);
		
		//	채팅방에 멤버 추가
		//	#{chatRoomNo}, #{chatMemberId}
		ChatMember addMember = new ChatMember();
		addMember.setChatRoomNo((int)paramMap.get("chatRoomNo"));	//	select key로 받아온 채팅방 번호
		
		//	본인
		addMember.setChatMemberId(String.valueOf(paramMap.get("login")));
		chatMemberMapper.insertChatMember(addMember);
		
		addMember.setChatMemberId(String.valueOf(chatMember.get("chatMemberId")));
		chatMemberMapper.insertChatMember(addMember);
		
		return paramMap;
	}

	/**
	 * 하나의 채팅방 정보 리턴 (기존 채팅 내역, 채팅방 정보)
	 */
	@Override
	@Transactional
	public Map<String, Object> getChatRoom(Map<String, Object> paramMap) {
		log.debug(TeamColor.CSK + "getChatRoom");
		log.debug(TeamColor.CSK + paramMap);
		
		//	기존 채팅 메세지 정보 불러오기
		Map<String, Object> map = new HashMap<>();
		
		List<Map<String, Object>> msgList = chatMsgMapper.selectMsgListByChatRoomNo(paramMap);
		map.put("msgList", msgList);
		
		int chatMemberNo = chatMemberMapper.selectChatRoomNoByJoinMemberId(paramMap);
		map.put("chatMemberNo", chatMemberNo);
		
		return map;
	}

	/**
	 * 채팅 메세지 저장
	 */
	@Override
	@Transactional
	public void addChatMsg(Map<String, Object> map) {
		int result = chatMsgMapper.insertChatMsg(map);
		
		if (result != 1) {
			throw new RuntimeException();
		}
	}

}
