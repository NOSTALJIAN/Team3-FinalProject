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

	@Select("SELECT uid2 FROM userRelationship WHERE uid=#{uid} AND relationship = 1;")
	List<String> getMateList(String uid);

	

}
