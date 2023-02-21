package com.mulcam.SpringProject.chat;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ChatMessageService {
	
	private final ModelMapper modelMapper;
	private final ChatRoomService chatRoomService;
	private final ChatMessageRepository chatMessageRepository;
	
	public ChatMessage createChatMessage(ChatMessageDto chatMessageDto) {
		
		ChatMessage chatMessage = modelMapper.map(chatMessageDto, ChatMessage.class);
		chatMessage.setCreatedAt(LocalDateTime.now());
		
		log.info("ChatMessageService::chatMessage : " + chatMessage);
		log.info("ChatMessageService::chatMessage cid : " + chatMessage.getCid());
		
		chatRoomService.updateLastChatMesg(chatMessage.getCid(), chatMessage);
		
		return chatMessage;
	}
	
	public ChatMessage findById(String chatMessageId) {
		return chatMessageRepository.findById(chatMessageId).orElseThrow();
	}
	
	public List<ChatMessage> findChatMessageWithPaging(int page, String cid) {
		
		int pagePerCount = 15;
		
		Sort sort = Sort.by("cretedAt").ascending();
		PageRequest pageRequest = PageRequest.of(page - 1, pagePerCount, sort);
		
		List<ChatMessage> result = chatMessageRepository.findListByRoomId(cid, pageRequest).getContent();
		
		return result;
	}
}
