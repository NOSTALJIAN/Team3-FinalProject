package com.mulcam.SpringProject.service;

import java.util.List;

import org.openqa.selenium.devtools.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.BoardDao;
import com.mulcam.SpringProject.entity.Board;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired 
	private BoardDao boardDao;
	
	@Override
	public List<Board> getBoardList(int page, String field, String query) {
		int offset = (page - 1) * 10;
		query = "%"+query+"%";
		List<Board> list = boardDao.getBoardList(offset, field, query);
		return list;
	}

	@Override
	public Board getBoard(int bid) {
		return boardDao.getBoard(bid);
	}

	@Value("${spring.servlet.multipart.location}")
	String uploadDir;

	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int bid) {
		boardDao.deleteBoard(bid);
	}
	
	@Override
	public int getBoardCount(String field, String query) {
		query = "%"+query+"%";
		int count = boardDao.getBoardCount(field, query);
		return count;
	}

	@Override
	public void increaseViewCount(int bid) {
		String field = "bViewCount";
		boardDao.increaseCount(bid, field);
		
	}
	@Override
	public void increaseReplyCount(int bid) {
		String field = "bReplyCount";
		boardDao.increaseCount(bid, field);
	}

	@Override
	public List<Reply> getReplyList(int bid) {
		return null;
	}

	@Override
	public void insertReply(Reply reply) {
		
	}

}


	

