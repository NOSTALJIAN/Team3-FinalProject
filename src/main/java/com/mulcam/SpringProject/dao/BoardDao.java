package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.SpringProject.entity.Board;

@Mapper
public interface BoardDao {

	@Select("select * from board")
	public List<Board> list();
	
	@Select("select * from board where bid=#{bid}")
	public Board getBoard(int bid);
	
	@Insert("INSERT INTO board VALUES(DEFAULT, #{uid}, #{bTitle}, #{bCategory}, #{bUserCount}, #{bContent}, DEFAULT, #{bAppointment}, "
			+ " DEFAULT, DEFAULT, #{bLocation}, #{bAddr}, #{bFiles}, DEFAULT)")

	public void insertBoard(Board board);

	@Update("UPDATE board SET ${field}=${field}+1 WHERE bid=#{bid}")
	public void increaseCount(int bid, String field);
}
