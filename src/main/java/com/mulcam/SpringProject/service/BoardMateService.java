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

	List<Board> getApplyList(String uid, int page);

	List<BoardMate> getReceiveList(String uid, int bid);

	List<Board> getMyList(String uid, int page);
	
	int getMyListCount(String uid);
	
	int getApplyListCount(String uid);

	List<Board> getDoneList(String uid);

	List<Board> getMyDoneList(String uid);

	void increaseApplyCount(int bid);

	List<BoardMate> getGMList(String uid, int bid);

	int getUserCount(int bid);

	int getApplyCount(int bid);

	void updateIsFull(int bid);

	int getbIsFull(int bid);

	int getApplyDoneCount(String uid);

	int getMyDoneCount(String uid);


}
