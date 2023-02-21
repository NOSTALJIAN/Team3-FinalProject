package com.mulcam.SpringProject.chat;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatUserService {
	
	private final UserMapper userMapper;
	
	public ChatUser findById(String uid) {
		return userMapper.findById(uid);
	}

}
