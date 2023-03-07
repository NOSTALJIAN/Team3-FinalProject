package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.SpringProject.entity.Board;

@Mapper
public interface BoardDao {

	@Select("SELECT b.bid, b.uid, b.bTitle, b.bCategory, b.bLocation, b.bAddr, b.bAppointment, b.bUserCount,"
			+ " b.bRegTime, b.bViewCount, b.bReplyCount, u.uname, b.applyCount, b.bIsFull FROM board AS b"
			+ "	JOIN users AS u JOIN boardMate as bm"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.bIsDeleted=0 AND ${field} LIKE #{query}"
			+ " AND b.bid NOT IN (SELECT bid FROM boardMate where uid=#{uid})"
			+ " ORDER BY bid DESC"
			+ "	LIMIT 9 OFFSET #{offset};")
	public List<Board> getBoardList(int offset, String field, String query, String uid);
	
	@Select("SELECT b.bid, b.uid, b.bTitle, b.bCategory, b.bLocation, b.bAddr, b.bAppointment, b.bUserCount,"
			+ " b.bRegTime, b.bViewCount, b.bReplyCount, u.uname, b.applyCount, b.bIsFull FROM board AS b"
			+ "	JOIN users AS u"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.bIsDeleted=0 AND ${field} LIKE #{query}"
			+ " AND b.bAppointment>=#{startDate} AND b.bAppointment<=#{endDate}"
			+ " AND b.bid NOT IN (SELECT bid FROM boardMate where uid=#{uid})"
			+ " ORDER BY b.bAppointment ASC"
			+ "	LIMIT 9 OFFSET #{offset};")
	public List<Board> getBoardListByPeriod(int offset, String field, String query, String startDate, String endDate, String uid);
	
	@Select("SELECT b.bid, b.uid, b.bTitle, b.bCategory, b.bLocation, b.bAddr, b.bAppointment, b.bUserCount,"
			+ " b.bRegTime, b.bViewCount, b.bReplyCount, u.uname, b.applyCount, b.bIsFull FROM board AS b"
			+ "	JOIN users AS u"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.bIsDeleted=0 AND ${field} LIKE #{query}"
			+ " AND b.bAppointment>=#{startDate} AND b.bAppointment<=#{endDate}"
			+ " AND b.bid NOT IN (SELECT bid FROM boardMate where uid=#{uid})"
			+ " AND b.bIsFull=#{bIsFull}"
			+ " ORDER BY b.bAppointment ASC"
			+ "	LIMIT 9 OFFSET #{offset};")
	public List<Board> getBoardListByPeriodFull(int offset, String field, String query, String startDate, String endDate, String uid, int bIsFull);
	
	@Select("SELECT COUNT(bid) FROM board AS b"
			+ "	JOIN users AS u"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.bIsDeleted=0 AND ${field} LIKE #{query}")
	public int getBoardCount(String field, String query);
	
	@Select("select count(*) from board where bIsDeleted=0 AND ${field} LIKE #{query} and bAppointment>=#{startDate} AND bAppointment<=#{endDate}" 
			+ "AND bid NOT IN (SELECT bid FROM boardMate where uid=#{uid})")
	int getBoardCountByPeriod(String field, String query, String startDate, String endDate, String uid);
	
	@Select("select count(*) from board where bIsDeleted=0 AND ${field} LIKE #{query} and bAppointment>=#{startDate} AND bAppointment<=#{endDate}" 
			+ "AND bid NOT IN (SELECT bid FROM boardMate where uid=#{uid}) AND bIsFull=#{bIsFull}")
	int getBoardCountByPeriodFull(String field, String query, String startDate, String endDate, String uid, int bIsFull);
	
	@Select("select * from board where bid=#{bid}")
	public Board getBoard(int bid);
	
	@Update("UPDATE board SET ${field}=${field}+1 WHERE bid=#{bid}")
	public void increaseCount(int bid, String field);
	
	@Insert("INSERT INTO board VALUES(DEFAULT, #{uid}, #{bTitle}, #{bCategory}, #{bUserCount}, #{bContent}, DEFAULT, #{bAppointment}, "
			+ " DEFAULT, DEFAULT, #{bLocation}, #{bAddr},DEFAULT, DEFAULT, DEFAULT, DEFAULT)")
	public void insertBoard(Board board);
	
	@Update("UPDATE board SET bTitle=#{bTitle}, bCategory=#{bCategory}, bUserCount=#{bUserCount}, bContent=#{bContent},"
			+ " bAppointment=#{bAppointment}, bRegTime=NOW(), bLocation=#{bLocation}, bAddr=#{bAddr} WHERE bid=#{bid}")
	public void updateBoard(Board board);
	
	@Update("UPDATE board SET bIsDeleted=1 WHERE bid=#{bid}")
	public void deleteBoard(int bid);
	
	@Update("UPDATE board SET applyCount=applyCount+1 WHERE bid=#{bid}")
	public void increaseApplyCount(int bid);
	
	@Select("SELECT bUserCount from board where bid=#{bid}")
	public int getUserCount(int bid);
	
	@Select("SELECT applyCount from board where bid=#{bid}")
	public int getApplyCount(int bid);
	
	@Update("UPDATE board SET bIsFull=1 where bid=#{bid}")
	public void updateIsFull(int bid);
	
	@Select("SELECT bIsFull from board where bid=#{bid}")
	public int getbIsFull(int bid);

	@Select("SELECT COUNT(*) FROM boardRelationship	WHERE bid = #{bid} AND uid2 = #{sessionUid};")
	public int getBoardRelationShipState(String sessionUid, int bid);

	@Select("SELECT COUNT(*) FROM boardMate	WHERE bid = #{bid} AND uid = #{sessionUid};")
	public int getBoardMateState(String sessionUid, int bid);
	
	
	
}
