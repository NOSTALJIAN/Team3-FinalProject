package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.Board;

@Mapper
public interface BoardDao {

	@Select("select * from board")
	List<Board> list();
	
	@Select("select * from board where bid=#{bid};")
	Board detail(int bid);
	
//	@Insert("insert into board values where (default, #{uid}, #{exercise_category_id}, #{b_title}, #{b_content}, #{b_regTime}, #{b_viewCount}, #{b_replyCount}, #{b_location}, default)")
//	void bInsert(Board b) {
		
	@Insert("INSERT INTO board VALUES(#{bid}, #{uid}, #{b_title}, #{b_content}, #{b_regTime}"
			+ " DEFAULT, DEFAULT, #{b_location}, DEFAULT")
	public void insertBoard(Board board);
}
