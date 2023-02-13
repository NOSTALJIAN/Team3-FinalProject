package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.Reply;

@Service
public interface BoardService {

	/** 게시글목록 페이지 출력 */
	public List<Board> getBoardList(int page, String field, String query);
	
	public List<Board> getBoardListByPeriod(int page, String field, String query, String startDate, String endDate);
	
	/** 디테일 페이지 출력 */
	public Board getBoard(int bid) ;
	
	/** 게시물 등록 */
	public void insertBoard(Board board);
	
	/** 게시물 수정 */
	public void updateBoard(Board board);
	
	/** 게시물 삭제 */
	public void deleteBoard(int bid);

	public int getBoardCount(String field, String query);
	
	public void increaseViewCount(int bid) ;

	public void increaseReplyCount(int bid, int count);
	
	public List<Reply> getReplyList(int bid);
	
	public void insertReply(Reply reply);

	public void updateReply(Reply reply);

	public void deleteReply(int rid);
		
	}
	

