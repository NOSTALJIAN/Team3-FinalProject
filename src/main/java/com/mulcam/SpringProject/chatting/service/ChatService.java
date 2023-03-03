package com.mulcam.SpringProject.chatting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.chatting.domain.ChatMsg;
import com.mulcam.SpringProject.chatting.domain.ChatRoom;
import com.mulcam.SpringProject.chatting.repository.ChatRepository;
import com.mulcam.SpringProject.chatting.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
	private final RoomRepository roomRepository;
	private final ChatRepository chatRepository;
	
	public List<ChatRoom> findAllRoom() {
		return roomRepository.findAll();
	}
	
	public ChatRoom findRoomById(int cid) {
		return roomRepository.findById(cid).orElseThrow();
	}
	
	public ChatRoom createRoom(String uid) {
		return roomRepository.save(ChatRoom.createChatRoom(uid));
	}
	
	public ChatMsg createChat(int cid, String sender, String content) {
		ChatRoom chatRoom = roomRepository.findById(cid).orElseThrow();
		return chatRepository.save(ChatMsg.createChatMsg(chatRoom, sender, content));
	}
	
	public List<ChatMsg> findAllChatByRoomId(int cid) {
		return chatRepository.findAllByRoomId(cid);
	}
}
