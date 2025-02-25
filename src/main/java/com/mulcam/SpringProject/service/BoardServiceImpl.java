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
	public List<Board> getBoardList(int page, String field, String query, String uid) {
		int offset = (page - 1) * 9;
		query = "%"+query+"%";
		List<Board> list = boardDao.getBoardList(offset, field, query, uid);
		return list;
	}
	
	@Override
	public List<Board> getBoardListByPeriod(int page, String field, String query, String startDate, String endDate, String uid) {
		int offset = (page - 1) * 9;
		query = "%"+query+"%";
		List<Board> list = boardDao.getBoardListByPeriod(offset, field, query, startDate, endDate, uid);
		return list;
	}
	
	@Override
	public List<Board> getBoardListByPeriodFull(int page, String field, String query, String startDate, String endDate, String uid, int bIsFull) {
		int offset = (page - 1) * 9;
		query = "%"+query+"%";
		List<Board> list = boardDao.getBoardListByPeriodFull(offset, field, query, startDate, endDate, uid, bIsFull);
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

	@Override
	public int getBoardCountByPeriod(String field, String query, String startDate, String endDate, String uid) {
		query = "%"+query+"%";
		int count = boardDao.getBoardCountByPeriod(field, query, startDate, endDate, uid);
		return count;
	}
	
	@Override
	public int getBoardCountByPeriodFull(String field, String query, String startDate, String endDate, String uid, int bIsFull) {
		query = "%"+query+"%";
		int count = boardDao.getBoardCountByPeriodFull(field, query, startDate, endDate, uid, bIsFull);
		return count;
	}
	
	@Override
	public String getBoardState(String sessionUid, int bid) {
		String state = "";
		int count1 = boardDao.getBoardRelationShipState(sessionUid, bid);
		if (count1 > 0) {
			state = "참가완료";
		} else {
			int count2 = boardDao.getBoardMateState(sessionUid, bid); 
			if (count2 > 0) {
				state = "참가신청중";
			} else {
				state = "참가신청";
			}
		}
		return state;
	}

}


	

