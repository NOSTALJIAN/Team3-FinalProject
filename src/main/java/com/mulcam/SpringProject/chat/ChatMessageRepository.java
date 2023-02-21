package com.mulcam.SpringProject.chat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {
	@Transactional(readOnly = true)
	Page<ChatMessage> findListByRoomId(String cid, Pageable pageable);
}
