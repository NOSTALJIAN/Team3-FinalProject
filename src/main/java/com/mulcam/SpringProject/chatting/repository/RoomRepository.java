package com.mulcam.SpringProject.chatting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mulcam.SpringProject.chatting.domain.ChatRoom;

public interface RoomRepository extends JpaRepository<ChatRoom, Integer> {

}
