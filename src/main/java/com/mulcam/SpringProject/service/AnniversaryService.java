package com.mulcam.SpringProject.service;

import java.util.List;

import com.mulcam.SpringProject.entity.Anniversary;

public interface AnniversaryService {

	List<Anniversary> getDayAnnivList(String sdate);

	List<Anniversary> getAnnivDays(String start, String end);
	
	void insert(Anniversary anniversary);
}