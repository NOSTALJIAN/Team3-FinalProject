package com.mulcam.SpringProject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Autowired
	private BoardMateDao bMateDao;
	
	@Override
	public void apply(BoardMate bMate) {
		bMateDao.apply(bMate);
	}

	@Override
	public void applyCancel(BoardMate bMate) {
		bMateDao.applyCancel(bMate);
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
	public List<UserInfo> getReceiveList(String uid) {
		List<UserInfo> list = bMateDao.getReceiveList(uid);
		return list;
	}
	
}
