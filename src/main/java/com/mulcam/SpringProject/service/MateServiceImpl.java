package com.mulcam.SpringProject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.MateDao;
import com.mulcam.SpringProject.entity.Mate;
import com.mulcam.SpringProject.session.UserSession;

@Service
public class MateServiceImpl implements MateService{
	@Resource
	private UserSession userSession;
	
	@Autowired
	private MateDao mateDao;
	
	
	@Override
	public void addMateAppl(Mate mate) {
		mateDao.addMateAppl(mate);
	}
	@Override
	public void mateCancle(Mate mate) {
		mateDao.mateCancle(mate);
	}
	
	@Override
	public void mateAccept(Mate mate) {
		mateDao.mateAccept(mate);
		mateDao.mateCancle(mate);
		mateDao.mateCancle2(mate);
	}

	@Override
	public int confirm(Mate mate) {
		int confirmNum = mateDao.confirm(mate);
		return confirmNum;
	}
	@Override
	public int confirm2(Mate mate) {
		int confirmNum2 = mateDao.confirm2(mate);
		return confirmNum2;
	}
	
	@Override
	public List<Mate> getAddMate(String uid) {
		List<Mate> list = mateDao.getAddMate(uid);
		return list;
	}

	@Override
	public List<Mate> getReceiveMate(String uid) {
		List<Mate> list = mateDao.getReceiveMate(uid);
		return list;
	}

	@Override
	public List<Mate> getMateList(String uid) {
		List<Mate> list = mateDao.getMateList(uid);
		return list;
	}
	@Override
	public List<Mate> getAddMateList(String uid) {
		List<Mate> list = mateDao.getAddMateList(uid);
		return list;
	}
	@Override
	public List<Mate> getReceiveMateList(String uid) {
		List<Mate> list = mateDao.getReceiveMateList(uid);
		return list;
	}
	@Override
	public void mateDelete(String user, String mateId) {
		mateDao.mateDelete(user, mateId);
		mateDao.mateDelete(mateId, user);
	}
	

}
