package com.mulcam.SpringProject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.BoardDao;
import com.mulcam.SpringProject.dao.BoardMateDao;
import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.BoardMate;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;
import com.mulcam.SpringProject.session.UserSession;

@Service
public class BoardMateServiceImpl implements BoardMateService {
	@Resource
	private UserSession userSession;
	
	@Autowired private BoardMateDao bMateDao;
	
	@Autowired private BoardDao boardDao;
	
	@Override
	public void apply(BoardMate bMate) {
		bMateDao.apply(bMate);
	}

	@Override
	public void applyCancel(BoardMate bMate) {
		bMateDao.applyCancel(bMate);
	}
	
	@Override
	public void applyCancel2(BoardMate bMate) {
		bMateDao.applyCancel2(bMate);
	}

	@Override
	public void applyAccept(BoardMate bMate) {
		bMateDao.applyAccept(bMate);
		bMateDao.applyCancel(bMate);
		bMateDao.applyCancel2(bMate);
	}
	
	@Override
	public int confirm(BoardMate bMate) {
		int confirmNum = bMateDao.confirm(bMate);
		return confirmNum;
	}
	@Override
	public int confirm2(BoardMate bMate) {
		int confirmNum2 = bMateDao.confirm2(bMate);
		return confirmNum2;
	}

	@Override
	public List<Board> getApplyList(String uid) {
		List<Board> list = bMateDao.getApplyList(uid);
		return list;
	}

	@Override
	public List<BoardMate> getReceiveList(String uid, int bid) {
		List<BoardMate> list = bMateDao.getReceiveList(uid, bid);
		return list;
	}

	@Override
	public List<Board> getMyList(String uid) {
		List<Board> list = bMateDao.getMyList(uid);
		return list;
	}

	@Override
	public List<Board> getDoneList(String uid) {
		List<Board> list = bMateDao.getDoneList(uid);
		return list;
	}

	@Override
	public List<Board> getMyDoneList(String uid) {
		List<Board> list = bMateDao.getMyDoneList(uid);
		return list;
	}

	@Override
	public void increaseApplyCount(int bid) {
		boardDao.increaseApplyCount(bid);
	}

	@Override
	public List<BoardMate> getGMList(String uid, int bid) {
		List<BoardMate> list = bMateDao.getGMList(uid, bid);
		return list;
	}

	@Override
	public int getUserCount(int bid) {
		int count = boardDao.getUserCount(bid);
		return count;
	}

	@Override
	public int getApplyCount(int bid) {
		int applyCount = boardDao.getApplyCount(bid);
		return applyCount;
	}

	@Override
	public void updateIsFull(int bid) {
		boardDao.updateIsFull(bid);
	}

	@Override
	public int getbIsFull(int bid) {
		int bIsFull = boardDao.getbIsFull(bid);
		return bIsFull;
	}

	
}
