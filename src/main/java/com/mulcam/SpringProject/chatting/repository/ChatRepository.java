package com.mulcam.SpringProject.chatting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mulcam.SpringProject.chatting.domain.ChatMsg;

public interface ChatRepository extends JpaRepository<ChatMsg, Integer> {

	List<ChatMsg> findAllByRoomId(int cid);
}
