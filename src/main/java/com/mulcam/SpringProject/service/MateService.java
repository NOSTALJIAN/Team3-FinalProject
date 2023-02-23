package com.mulcam.SpringProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.Mate;

@Service
public interface MateService {
	
	void addMateAppl(Mate mate);

	int confirm(Mate mate);

	List<Mate> getAddMate(String uid);

	List<Mate> getReceiveMate(String uid);

	void mateCancle(Mate mate);

	void mateAccept(Mate mate);

	List<Mate> getMateList(String uid);

	int confirm2(Mate mate);

	List<Mate> getAddMateList(String uid);

	List<Mate> getReceiveMateList(String uid);

	void mateDelete(String user, String mateId);

}
