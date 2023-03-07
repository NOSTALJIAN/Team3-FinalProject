package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.SpringProject.entity.MatchingCondition;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;

@Mapper
public interface UserDao {
	
	@Insert("INSERT into users values(#{uid}, #{pwd}, #{uname}, #{nickname}, NULL,#{phoneNum}, #{email}, #{emailCheck}, default, default, default)")
	void insert(User u);

	@Insert("INSERT into userInfo values(#{uid}, #{uPostcode}, #{uAddr}, #{uDetailAddr}, #{likeExercise}, #{birthDate}, #{gender}, default, #{uLat}, #{uLng})")
	void insertInfo(UserInfo ui);
	
	@Select("SELECT * from users where uid=#{uid}")
	User getUser(String uid);
	
	@Select("SELECT * from users where email=#{email}")
	User getEmail(String email);
	
	@Select("SELECT uname from users where uid=#{uid}")
	String getUname(String uid);
	
	@Select("SELECT nickname from users where uid=#{uid}")
	String getNickname(String uid);

	@Select("SELECT * from users where phoneNum=#{phoneNum}")
	User getPhoneNum(String phoneNum);
	
	@Select("SELECT uid, uPostcode, uAddr, likeExercise, birthDate, gender, uRating, uLat, uLng, "
			+ " CONVERT(BIN(likeExercise & (SELECT likeExercise FROM userInfo WHERE uid = #{uid})), CHAR(12)) coincideExer"
			+ "	FROM userInfo"
			+ " WHERE (likeExercise & #{bestExer}) != 0"
			+ " AND (gender = #{pGender} or '모두' = #{pGender})"
			+ " AND ((YEAR(CURRENT_TIMESTAMP) - (birthDate/10000)) >= #{minAge} AND (YEAR(CURRENT_TIMESTAMP) - (birthDate/10000)) <= #{maxAge})"
			+ "	AND uid != #{uid};")
	List<UserInfo> getCoincideInfo(String uid, int minAge, int maxAge, String pGender, int bestExer);

	@Select("SELECT * from userInfo WHERE uid = #{sessionUid};")
	UserInfo getUserInfo(String sessionUid);

	@Select("SELECT CONVERT(BIN (likeExercise), CHAR(12)) FROM userInfo WHERE uid = #{uid};")
	String getLikeExercise(String uid);

	@Select("SELECT * FROM matchingCondition WHERE uid = #{uid};")
	MatchingCondition getCondition(String uid);

	@Insert("INSERT into matchingCondition values(#{uid}, #{bestExercise}, #{minAge}, #{maxAge}, #{minDistance}, #{maxDistance}, #{pGender})")
	void insertCondition(MatchingCondition mC);

	@Update("UPDATE matchingCondition SET bestExercise=#{bestExercise}, minAge=#{minAge}, maxAge=#{maxAge},minDistance=#{minDistance}, "
			+ "maxDistance=${maxDistance}, pGender=#{pGender} WHERE uid=#{uid};")
	void updateCondition(MatchingCondition mC);

	@Update("UPDATE users SET nickname=#{nickname}, phoneNum=#{phoneNum}, email=#{email}, emailCheck=#{emailCheck} WHERE uid=#{uid};")
	void update(User u);

	@Update("UPDATE userInfo SET uPostcode=#{uPostcode}, uAddr=#{uAddr}, uDetailAddr=#{uDetailAddr}, likeExercise=#{likeExercise}, "
			+ "uLat=#{uLat}, uLng=#{uLng} WHERE uid=#{uid};")
	void updateInfo(UserInfo ui);

	@Update("Update users SET pwd=#{pwd} WHERE uid=#{uid};")
	void updatePwd(String uid, String pwd);

	@Select("SELECT uImage FROM users WHERE uid=#{uid};")
	String getUimage(String uid);

	@Update("UPDATE users SET uImage=#{fname} WHERE uid=#{uid}")
	void profileUpload(String uid, String fname);

	@Select("SELECT * from users")
	List<User> getUserAllList();

	@Select("SELECT * from users WHERE uIsDeleted = #{isDeleted}")
	List<User> getUserList(int isDeleted);

	@Update("Update users SET uIsDeleted=#{isDeleted} WHERE uid=#{uid};")
	void userIsDeleted(String uid, int isDeleted);

	@Select("SELECT * FROM users WHERE nickname = #{data};")
	User CheckNickname(String data);

    /** 이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크 */
    public User checkUserWithSessionKey(String sessionId);
}