package com.mulcam.SpringProject.chat;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatUserService {
	
	private final UserMapper userMapper;
	
	public User findById(String uid) {
		return userMapper.findById(uid);
	}

}
