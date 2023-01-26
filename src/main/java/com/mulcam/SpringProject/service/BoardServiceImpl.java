package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.BoardDao;
import com.mulcam.SpringProject.entity.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired 
	private BoardDao boardDao;
	
	@Override
	public List<Board> list() {
		return boardDao.list();
	}

	@Override
	public Board detail(int bid) {
		return boardDao.detail(bid);
	}

}
