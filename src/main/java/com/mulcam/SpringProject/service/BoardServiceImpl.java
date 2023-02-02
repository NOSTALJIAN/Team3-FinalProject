package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mulcam.SpringProject.dao.BoardDao;
import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.User;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired 
	private BoardDao boardDao;
	
	@Override
	public List<Board> list() {
		return boardDao.list();
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
		
	}

	@Override
	public void deleteBoard(int bid) {
		
	}

	@Override
	public void increaseViewCount(int bid) {
		String field = "viewCount";
		boardDao.increaseCount(bid, field);
		
	}

	}


	

