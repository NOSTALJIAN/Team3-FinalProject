package com.mulcam.SpringProject.chat;

import org.apache.ibatis.annotations.Mapper;

import com.mulcam.SpringProject.entity.User;

@Mapper
public interface UserMapper {
	User findById(String uid);
}