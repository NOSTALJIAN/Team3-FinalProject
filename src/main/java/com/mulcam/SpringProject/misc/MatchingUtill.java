package com.mulcam.SpringProject.misc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.MatchingUsers;
import com.mulcam.SpringProject.entity.UserInfo;
import com.mulcam.SpringProject.service.UserService;

@Service
public class MatchingUtill {
	@Autowired private UserService service;
	@Autowired private ExerciseUtill exerciseUtill;
	@Autowired private MapUtill mapUtill;
	
	/** 좋아하는 운동이 하나라도 일치하는 사람들의 리스트*/
	public List<MatchingUsers> matchingList(String sessionUid){
		
		// 오늘자 연도(나이계산을 위해서)
		int year =  LocalDate.now().getYear();
		UserInfo user = service.getUserInfo(sessionUid);
		// 거리 계산용
		double lat1 = user.getuLat();
		double lng1 = user.getuLng();
		String distance = "";
		
		
		// 좋아하는 운동이 하나라도 일치하는 사람들의 리스트
		List<UserInfo> coincideList = service.getCoincideInfo(sessionUid);
		List<MatchingUsers> matchingList = new ArrayList<>();
		for (UserInfo ui : coincideList) {
			String uid = ui.getUid();
			String gender = ui.getGender();
			float uRating = ui.getuRating();
			// 거리계산
			double lat2 = ui.getuLat();
			double lng2 = ui.getuLng();
			double dist = mapUtill.distance(lat1, lng1, lat2, lng2);
			if (dist >= 1.0) {
				distance =  String.format("%.1f" , dist) + "km";
			} else {
				distance =  (int) (dist*1000) + "m";
			}
			// 일치하는 운동 보여주기
			String coincideNum = String.format("%12s", ui.getCoincideExer());
			List<String> coincideExer = exerciseUtill.findExercise(coincideNum);
			// 나이계산
			int age = year - (ui.getBirthDate()/10000);
			// 알고리즘 점수 계산
			float score = (float) (exerciseUtill.countOne(coincideNum)*30 + uRating*10 - dist);
			
			MatchingUsers matchingUser = new MatchingUsers(uid, distance, age, coincideExer, gender, uRating, score);
			matchingList.add(matchingUser);
		}
		
		// score를 기준으로 내림차순 정렬
		Collections.sort(matchingList, (m1, m2) -> (int)(m2.getScore()- m1.getScore()));
		
		return matchingList;
	}
}

