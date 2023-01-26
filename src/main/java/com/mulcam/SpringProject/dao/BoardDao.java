package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.Board;

@Mapper
public interface BoardDao {

	@Select("select * from board")
	List<Board> list();
	
	@Select("select * from board where bid=#{bid};")
	Board detail(int bid);
	
	
}
