package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.SpringProject.entity.Board;

@Mapper
public interface BoardDao {

	@Select("select * from board order by bid desc")
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



}
