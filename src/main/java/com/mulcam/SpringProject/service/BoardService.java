package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.User;

@Service
public interface BoardService {

	/** 게시글목록 페이지 출력 */
	public List<Board> list();
	
	/** 디테일 페이지 출력 */
	public Board getBoard(int bid) ;
	
	/** 게시물 등록 
	 * @return */
	public void insertBoard(Board board);
	
	public void updateBoard(Board board);
	
	public void deleteBoard(int bid);

	public void increaseViewCount(int bid) ;



		
	}
	

