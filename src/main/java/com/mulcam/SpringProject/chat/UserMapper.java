package com.mulcam.SpringProject.chat;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	ChatUser findById(String uid);
}