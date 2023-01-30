package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;

@Service
public interface UserService {
	public static final int CORRECT_LOGIN=0;
	public static final int WRONG_PASSWORD=1;
	public static final int UID_NOT_EXIST=2;
	
	void register(User u);

	void register_info(UserInfo ui);

	User getUser(String uid);

	User getEmail(String email);

	User getNickname(String nickname);

	User getPhoneNum(String phoneNum);

	int login(String uid, String pwd);
	
	
	// User_info 정보
	List<UserInfo> getCoincide_info(String uid);
	
	
	
}
