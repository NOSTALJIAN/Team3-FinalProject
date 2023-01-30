package com.mulcam.SpringProject.service;

import java.util.List;

import org.openqa.selenium.devtools.Reply;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.User;

@Service
public interface BoardService {

	/** 게시글목록 페이지 출력 */
	List<Board> list();
	
	/** 디테일 페이지 출력 */
	Board detail(int bid);
	
	/** 게시물 등록 
	 * @return */
	public static Board insertBoard(int bid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateBoard(Board board);
	
	public void deleteBoard(int bid);

	static void increaseViewCount(int bid) {
		// TODO Auto-generated method stub
		
	}

	void insertBoard(Board board);

	static List<Reply> getReplyList(int bid) {
		// TODO Auto-generated method stub
		return null;
	}
		
	}
	

