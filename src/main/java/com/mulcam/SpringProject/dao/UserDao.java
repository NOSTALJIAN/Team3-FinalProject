package com.mulcam.SpringProject.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.User_info;

@Mapper
public interface UserDao {
	
	@Insert("insert into users values(#{uid}, #{pwd}, #{uname}, #{phoneNum}, #{nickname}, #{email}, #{email_check}, default, default, default)")
	void insert(User u);

	@Insert("insert into user_info values(#{uid}, #{u_addr}, #{like_exercise}, #{birth_date}, #{gender}, default)")
	void insert_info(User_info u_i);
	
	@Select("select * from users where uid=#{uid}")
	User getUser(String uid);
	
	@Select("select * from users where email=#{email}")
	User getEmail(String email);
	
	@Select("select * from users where nickname=#{nickname}")
	User getNickname(String nickname);

	@Select("select * from users where phoneNum=#{phoneNum}")
	User getPhoneNum(String phoneNum);
	
	
	User get(String uid);

}
