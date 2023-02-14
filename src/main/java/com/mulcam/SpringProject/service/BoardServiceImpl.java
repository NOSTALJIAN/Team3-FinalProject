package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.BoardDao;
import com.mulcam.SpringProject.dao.ReplyDao;
import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.Reply;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired 
	private BoardDao boardDao;
	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public List<Board> getBoardList(int page, String field, String query) {
		int offset = (page - 1) * 10;
		query = "%"+query+"%";
		List<Board> list = boardDao.getBoardList(offset, field, query);
		return list;
	}
	
	@Override
	public List<Board> getBoardListByPeriod(int page, String field, String query, String startDate, String endDate) {
		int offset = (page - 1) * 10;
		query = "%"+query+"%";
		List<Board> list = boardDao.getBoardListByPeriod(offset, field, query, startDate, endDate);
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
	public void increaseReplyCount(int bid, int count) {
		String field = "bReplyCount";
		boardDao.increaseCount(bid, field);
	}

	@Override
	public List<Reply> getReplyList(int bid) {
		List<Reply> list = replyDao.getReplyList(bid);
		return list;
	}

	@Override
	public void insertReply(Reply reply) {
		replyDao.insertReply(reply);
	}
	
	@Override
	public void updateReply(Reply reply) {
		replyDao.updateReply(reply);
	}

	@Override
	public void deleteReply(int rid) {
		replyDao.deleteReply(rid);
	}

}


	

