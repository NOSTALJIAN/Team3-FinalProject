package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.Mate;

@Mapper
public interface MateDao {
	@Insert("INSERT into addMate values(#{uid}, #{receiveUser}, default)")
	void addMateAppl(Mate mate);

	@Delete("DELETE FROM addMate WHERE uid = #{uid} AND receiveUser = #{receiveUser};")
	void mateCancle(Mate mate);
	
	@Delete("DELETE FROM addMate WHERE uid = #{receiveUser} AND receiveUser = #{uid};")
	void mateCancle2(Mate mate);
	
	@Insert("INSERT INTO userRelationship VALUES(#{uid}, #{receiveUser}, 1), (#{receiveUser}, #{uid}, 1)")
	void mateAccept(Mate mate);

	@Select("SELECT COUNT(*) FROM addMate WHERE uid=#{uid} AND receiveUser = #{receiveUser}")
	int confirm(Mate mate);
	
	@Select("SELECT COUNT(*) FROM userRelationship WHERE uid=#{uid} AND uid2 = #{receiveUser} ;")
	int confirm2(Mate mate);

	@Select("SELECT * FROM addMate WHERE uid = #{uid};")
	List<Mate> getAddMate(String uid);

	@Select("SELECT * FROM addMate WHERE receiveUser = #{uid};")
	List<Mate> getReceiveMate(String uid);

	@Select("SELECT  A.uid, A.uid2 AS receiveUser, nickname, uImage, gender, birthDate AS age"
			+ " FROM userRelationship AS A"
			+ " LEFT JOIN users AS B"
			+ "	ON A.uid2 = B.uid"
			+ " LEFT JOIN userInfo AS C"
			+ "	ON A.uid2 =  C.uid"
			+ "	WHERE A.uid = #{uid} AND A.relationship=1;")
	List<Mate> getMateList(String uid);

	@Select("SELECT  A.uid, receiveUser, sendTime , nickname, uImage, gender, birthDate AS age"
			+ " FROM addMate AS A"
			+ " LEFT JOIN users AS B"
			+ "	ON A.receiveUser = B.uid"
			+ " LEFT JOIN userInfo AS C"
			+ "	ON A.receiveUser =  C.uid"
			+ "	WHERE A.uid = #{uid};")
	List<Mate> getAddMateList(String uid);

	@Select("SELECT  A.uid, receiveUser, sendTime , nickname, uImage, gender, birthDate AS age"
			+ " FROM addMate AS A"
			+ " LEFT JOIN users AS B"
			+ "	ON A.uid = B.uid"
			+ " LEFT JOIN userInfo AS C"
			+ "	ON A.uid =  C.uid"
			+ "	WHERE A.receiveUser = #{uid};")
	List<Mate> getReceiveMateList(String uid);

	@Delete("DELETE FROM userRelationship WHERE uid = #{uid1} AND uid2 = #{uid2};")
	void mateDelete(String uid1, String uid2);

	

}
