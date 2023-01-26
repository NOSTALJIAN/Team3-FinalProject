package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.Board;

@Service
public interface BoardService {

	List<Board> list();
	Board detail(int bid);
	
	
}
