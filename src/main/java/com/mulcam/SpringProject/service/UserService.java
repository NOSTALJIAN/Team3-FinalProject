package com.mulcam.SpringProject.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.UserDao;
import com.mulcam.SpringProject.entity.MatchingCondition;
import com.mulcam.SpringProject.entity.Mate;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;

@Service
public interface UserService {
	public static final int CORRECT_LOGIN=0;
	public static final int WRONG_PASSWORD=1;
	public static final int UID_NOT_EXIST=2;
	public static final int UID_DELETE=3;
	public static final int UID_EXILE=4;
	
	void register(User u);

	void registerInfo(UserInfo ui);

	User getUser(String uid);

	User getEmail(String email);

	User getPhoneNum(String phoneNum);

	int login(String uid, String pwd);
	
	/** 사용자와 일치하는 유저 정보들 */
	List<UserInfo> getCoincideInfo(String uid, int minAge, int maxAge, String pGender, int bestExer);
	
	/** 사용자 정보*/
	UserInfo getUserInfo(String sessionUid);
	
	/** 이름 가져오기*/ 
	String getUname(String uid);
	
	/** 닉네임 가져오기*/
	String getNickname(String uid);

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

	/** 관리자용 유저리스트 가져오기 */
	List<User> getUserAllList();

	/** 관리자용 특정 유저리스트 가져오기*/
	List<User> getUserList(int isDeleted);

	/** 관리자용 유저관리*/
	void userIsDeleted(String uid, int isDeleted);

	/** 닉네임 중복체크용*/
	User CheckNickname(String data);
	
    /** 이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크 */
    public User checkUserWithSessionKey(String sessionId);
}
