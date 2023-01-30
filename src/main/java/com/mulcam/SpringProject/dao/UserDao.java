package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;

@Mapper
public interface UserDao {
	
	@Insert("insert into users values(#{uid}, #{pwd}, #{uname}, #{phoneNum}, #{nickname}, #{email}, #{emailCheck}, default, default, default)")
	void insert(User u);

	@Insert("insert into userInfo values(#{uid}, #{uPostcode}, #{uAddr}, #{uDetailAddr}, #{likeExercise}, #{birthDate}, #{gender}, default, #{uLat}, #{uLng})")
	void insertInfo(UserInfo ui);
	
	@Select("select * from users where uid=#{uid}")
	User getUser(String uid);
	
	@Select("select * from users where email=#{email}")
	User getEmail(String email);
	
	@Select("select * from users where nickname=#{nickname}")
	User getNickname(String nickname);

	@Select("select * from users where phoneNum=#{phoneNum}")
	User getPhoneNum(String phoneNum);

//	@Select("select uid, u_postcode, u_addr, like_exercise, birth_date, gender, u_rating"
//			+ "	, BIN(like_exercise & (SELECT like_exercise FROM userInfo WHERE uid=#{uid}))  AS coincide_exer"
//			+ "FROM userInfo"
//			+ "WHERE (like_exercise & (SELECT like_exercise FROM userInfo WHERE uid=#{uid2})) != 0"
//			+ "AND uid !=#{uid3};")
//	userInfo getCoincide_info(String uid, String uid2, String uid3);
	
	@Select("select uid, uPostcode, uAddr, likeExercise, birthDate, gender, uRating, "
			+ " BIN(likeExercise & (SELECT likeExercise FROM userInfo WHERE uid = #{uid})) coincideExer"
			+ "	FROM userInfo"
			+ "	WHERE (likeExercise & (SELECT likeExercise FROM userInfo WHERE uid=#{uid})) != 0"
			+ "	AND uid != #{uid};")
	List<UserInfo> getCoincide_info(String uid);

}
