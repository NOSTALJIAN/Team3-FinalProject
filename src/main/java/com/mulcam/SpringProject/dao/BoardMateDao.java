package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.BoardMate;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;

@Mapper
public interface BoardMateDao {
	@Insert("INSERT INTO boardMate VALUES(#{bid}, #{uid}, #{receiveUser}, DEFAULT);")
	void apply(BoardMate bMate);

	@Delete("DELETE FROM boardMate WHERE bid=#{bid} AND uid=#{uid} AND receiveUser=#{receiveUser};")
	void applyCancel(BoardMate bMate);
	
	@Delete("DELETE FROM boardMate WHERE bid=#{bid} AND uid=#{receiveUser} AND receiveUser=#{uid};")
	void applyCancel2(BoardMate bMate);
	
	@Insert("INSERT INTO boardRelationship VALUES(#{uid}, #{receiveUser}, 1, #{bid});")
	void applyAccept(BoardMate bMate);

	@Select("SELECT b.uid, b.bid, b.bTitle, b.bCategory, b.bLocation, b.bAppointment, b.bUserCount, bm.receiveUser, b.bIsFull, b.applyCount"
			+ "	FROM boardMate AS bm JOIN board AS b"
			+ "	WHERE bm.bid=b.bid AND bm.uid=#{uid} AND b.bIsDeleted=0 limit 10 offset #{offset};")
	List<Board> getApplyList(String uid, int offset);
	
	@Select("SELECT count(*) FROM boardMate AS bm JOIN board AS b"
			+ "	WHERE bm.bid=b.bid AND bm.uid=#{uid} AND b.bIsDeleted=0")
	int getApplyListCount(String uid);
	
	@Select("SELECT bm.bid, u.uid, u.likeExercise, u.gender, u.birthDate, bm.sendTime, b.bTitle"
			+ "	FROM userInfo AS u JOIN boardMate AS bm JOIN board AS b"
			+ "	WHERE u.uid=bm.uid AND bm.bid=b.bid AND bm.receiveUser=#{uid} AND bm.bid=#{bid};")
	List<BoardMate> getReceiveList(String uid, int bid);
	
	@Select("SELECT * FROM board WHERE uid=#{uid} AND bIsFull=0 AND bIsDeleted=0 limit 10 offset #{offset}")
	List<Board> getMyList(String uid, int offset);
	
	@Select("SELECT count(*) FROM board WHERE uid=#{uid} AND bIsFull=0 AND bIsDeleted=0;")
	int getMyListCount(String uid);
	
	@Select("SELECT b.uid, b.bid, b.bTitle, b.bCategory, b.bLocation, b.bAppointment, b.bUserCount, b.bIsFull"
			+ "	FROM board AS b JOIN boardRelationship as brs"
			+ "	WHERE b.bid=brs.bid AND brs.uid2=#{uid} AND brs.relationship=1 AND b.bIsDeleted=0;")
	List<Board> getDoneList(String uid);
	
	@Select("SELECT count(*) FROM board AS b JOIN boardRelationship as brs"
			+ "	WHERE b.bid=brs.bid AND brs.uid2=#{uid} AND brs.relationship=1 AND b.bIsDeleted=0;")
	int getApplyDoneCount(String uid);
	
	@Select("SELECT b.uid, b.bid, b.bTitle, b.bCategory, b.bLocation, b.bAppointment, b.bUserCount, b.bIsFull, b.applyCount"
			+ " FROM board AS b JOIN boardRelationship as brs"
			+ " WHERE b.uid=#{uid} AND brs.bid=b.bid AND b.bIsDeleted=0;")
	List<Board> getMyDoneList(String uid);
	
	@Select("SELECT count(DISTINCT (b.bid)) FROM board AS b JOIN boardRelationship as brs"
			+ " WHERE b.uid=#{uid} AND brs.bid=b.bid AND b.bIsDeleted=0;")
	int getMyDoneCount(String uid);
	
	@Select("SELECT br.bid, u.uid, u.likeExercise, u.gender, u.birthDate, b.bTitle"
			+ "	FROM userInfo AS u JOIN board AS b JOIN boardRelationship AS br"
			+ "	WHERE u.uid=br.uid2 AND br.bid=b.bid AND br.uid=#{uid} AND br.bid=#{bid};")
	List<BoardMate> getGMList(String uid, int bid);
	
	

}
