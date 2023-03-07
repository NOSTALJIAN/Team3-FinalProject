package com.mulcam.SpringProject.chatting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.chatting.dao.ChatDAO;
import com.mulcam.SpringProject.chatting.entity.ChatRoomVO;
import com.mulcam.SpringProject.chatting.entity.MessageVO;

import lombok.RequiredArgsConstructor;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatDAO cDao;

	@Override
	public ChatRoomVO selectChatRoom(String room_id) {
		return cDao.selectChatRoom(room_id);
	}

	@Override
	public int insertMessage(MessageVO chatMessage) {
		return cDao.insertMessage(chatMessage);
	}

	@Override
	public List<MessageVO> messageList(String room_id) {
		return cDao.messageList(room_id);
	}

	@Override
	public int createChat(ChatRoomVO room) {
		return cDao.createChat(room);
	}

	@Override
	public ChatRoomVO searchChatRoom(ChatRoomVO room) {
		return cDao.searchChatRoom(room);
	}

	@Override
	public List<ChatRoomVO> chatRoomList(String userEmail) {
		return cDao.chatRoomList(userEmail);
	}

	@Override
	public int selectUnReadCount(MessageVO message) {
		return cDao.selectUnReadCount(message);
	}

	@Override
	public int updateCount(MessageVO message) {
		return cDao.updateCount(message);
	}

	@Override
	public void deleteRoom(String room_id) {
		cDao.deleteRoom(room_id);
	}
	
}
