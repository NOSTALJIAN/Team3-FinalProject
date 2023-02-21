package com.mulcam.SpringProject.chat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
	@Transactional(readOnly = true)
	Page<ChatRoom> findListsByChatRoomMembersId(String uid, Pageable pageable);
}
