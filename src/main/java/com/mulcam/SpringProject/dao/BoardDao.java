package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.SpringProject.entity.Board;

@Mapper
public interface BoardDao {

	@Select("SELECT b.bid, b.uid, b.bTitle, b.bCategory, b.bLocation, b.bAppointment, b.bUserCount,"
			+ " b.bRegTime, b.bViewCount, b.bReplyCount, u.uname FROM board AS b"
			+ "	JOIN users AS u"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.bIsDeleted=0 AND ${field} LIKE #{query}"
			+ " ORDER BY bid DESC"
			+ "	LIMIT 10 OFFSET #{offset};")
	public List<Board> getBoardList(int offset, String field, String query);
	
	@Select("SELECT COUNT(bid) FROM board AS b"
			+ "	JOIN users AS u"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.bIsDeleted=0 AND ${field} LIKE #{query}")
	public int getBoardCount(String field, String query);
	
	@Select("select * from board where bid=#{bid}")
	public Board getBoard(int bid);
	
	@Update("UPDATE board SET ${field}=${field}+1 WHERE bid=#{bid}")
	public void increaseCount(int bid, String field);
	
	@Insert("INSERT INTO board VALUES(DEFAULT, #{uid}, #{bTitle}, #{bCategory}, #{bUserCount}, #{bContent}, DEFAULT, #{bAppointment}, "
			+ " DEFAULT, DEFAULT, #{bLocation}, #{bAddr}, #{bFiles}, DEFAULT)")
	public void insertBoard(Board board);
	
	@Update("UPDATE board SET bTitle=#{bTitle}, bCategory=#{bCategory}, bUserCount=#{bUserCount}, bContent=#{bContent},"
			+ " bAppointment=#{bAppointment}, bRegTime=NOW(), bLocation=#{bLocation}, bAddr=#{bAddr}, bFiles=#{bFiles} WHERE bid=#{bid}")
	public void updateBoard(Board board);
	
	@Update("UPDATE board SET bIsDeleted=1 WHERE bid=#{bid}")
	public void deleteBoard(int bid);
}
