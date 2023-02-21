package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.BoardMate;
import com.mulcam.SpringProject.entity.UserInfo;

@Service
public interface BoardMateService {

	void apply(BoardMate bMate);

	void applyCancel(BoardMate bMate);
	
	void applyCancel2(BoardMate bMate);

	void applyAccept(BoardMate bMate);

	int confirm(BoardMate bMate);

	int confirm2(BoardMate bMate);

	List<Board> getApplyList(String uid);

	List<BoardMate> getReceiveList(String uid, int bid);

	List<Board> getMyList(String uid);

	List<Board> getDoneList(String uid);


}
