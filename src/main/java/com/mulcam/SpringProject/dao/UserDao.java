package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;

@Mapper
public interface UserDao {
	
	@Insert("INSERT into users values(#{uid}, #{pwd}, #{uname}, NULL,#{phoneNum}, #{email}, #{emailCheck}, default, default, default)")	void insert(User u);

	@Insert("INSERT into userInfo values(#{uid}, #{uPostcode}, #{uAddr}, #{uDetailAddr}, #{likeExercise}, #{birthDate}, #{gender}, default, #{uLat}, #{uLng})")
	void insertInfo(UserInfo ui);
	
	@Select("SELECT * from users where uid=#{uid}")
	User getUser(String uid);
	
	@Select("SELECT * from users where email=#{email}")
	User getEmail(String email);
	
	@Select("SELECT uname from users where uid=#{uid}")
	String getUname(String uid);

	@Select("SELECT * from users where phoneNum=#{phoneNum}")
	User getPhoneNum(String phoneNum);
	
	@Select("SELECT uid, uPostcode, uAddr, likeExercise, birthDate, gender, uRating, uLat, uLng, "
			+ " CONVERT(BIN(likeExercise & (SELECT likeExercise FROM userInfo WHERE uid = #{uid})), CHAR(12)) coincideExer"
			+ "	FROM userInfo"
			+ "	WHERE (likeExercise & (SELECT likeExercise FROM userInfo WHERE uid=#{uid})) != 0"
			+ "	AND uid != #{uid};")
	List<UserInfo> getCoincideInfo(String uid);

	@Select("SELECT uid, uAddr, likeExercise, birthDate, gender, uRating, uLat, uLng from userInfo WHERE uid = #{sessionUid};")
	UserInfo getUserInfo(String sessionUid);


}