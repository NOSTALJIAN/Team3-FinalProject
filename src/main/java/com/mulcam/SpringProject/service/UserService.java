package com.mulcam.SpringProject.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.MatchingCondition;
import com.mulcam.SpringProject.entity.Mate;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;

@Service
public interface UserService {
	public static final int CORRECT_LOGIN=0;
	public static final int WRONG_PASSWORD=1;
	public static final int UID_NOT_EXIST=2;
	
	void register(User u);

	void registerInfo(UserInfo ui);

	User getUser(String uid);

	User getEmail(String email);

	User getPhoneNum(String phoneNum);

	int login(String uid, String pwd);
	
	/** 사용자와 일치하는 유저 정보들 */
	List<UserInfo> getCoincideInfo(String uid);
	
	/** 사용자 정보*/
	UserInfo getUserInfo(String sessionUid);
	
	String getUname(String uid);

	/** 최대 관심운동 가져오기*/
	String getLikeExercise(String uid);
	
	/** 매칭조건 가져오기 */
	MatchingCondition getCondition(String uid);
	
	/** 매칭조건 입력*/
	void insertCondition(MatchingCondition mC);
	
	/** 매칭조건 수정*/
	void updateCondition(MatchingCondition mC);

	/** 회원 정보 수정*/
	void update(User u, UserInfo ui);

	/** 비밀번호 변경*/
	void updatePwd(String uid, String newpwd);

	/** 프로필 사진 가져오기 */
	String getUimage(String uid);

	/** 프로필 사진 저장*/
	void profileUpload(String uid, String fname);

}
