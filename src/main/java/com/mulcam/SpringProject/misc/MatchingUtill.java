package com.mulcam.SpringProject.misc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.entity.Mate;
import com.mulcam.SpringProject.entity.MatchingCondition;
import com.mulcam.SpringProject.entity.MatchingUsers;
import com.mulcam.SpringProject.entity.UserInfo;
import com.mulcam.SpringProject.service.MateService;
import com.mulcam.SpringProject.service.UserService;

@Service
public class MatchingUtill {
	@Autowired private UserService service;
	@Autowired private MateService mateService;
	@Autowired private ExerciseUtill exerciseUtill;
	@Autowired private MapUtill mapUtill;
	
	/** 좋아하는 운동이 하나라도 일치하는 사람들의 리스트*/
	public List<MatchingUsers> matchingList(String sessionUid){
		
		// 오늘자 연도(나이계산을 위해서)
		int year =  LocalDate.now().getYear();
		
		// 거리 계산용
		UserInfo user = service.getUserInfo(sessionUid);
		double lat1 = user.getuLat();
		double lng1 = user.getuLng();
		String distance = "";
		
		// 좋아하는 운동과 필터링용
		MatchingCondition mC = service.getCondition(sessionUid);
		String bestExercise = mC.getBestExercise();
		int bestExer = 1;
		String[] exerciseList = {"축구", "농구", "야구", "E-sports", "등산", "당구", "볼링", "싸이클", "테니스", "조깅", "수영", "헬스"};
		for (String i : exerciseList) {
			if (bestExercise.equals(i)) {
				break;
			}
			bestExer = bestExer*2;
		}
		
		int minAge = mC.getMinAge();
		int maxAge = mC.getMaxAge();
		int minDistance = mC.getMinDistance();
		int maxDistance = mC.getMaxDistance();
		String pGender = mC.getpGender();
		
		// 좋아하는 운동이 하나라도 일치하는 사람들의 리스트
		// 필요 데이터 : uid, 성별, birthDate, bestExer, 
		List<UserInfo> coincideList = service.getCoincideInfo(sessionUid, minAge, maxAge, pGender, bestExer);
		List<MatchingUsers> matchingList = new ArrayList<>();
		for (UserInfo ui : coincideList) {
			String uid = ui.getUid();
			// 친구 추가신청 되있는지 확인
			int confirmNum = mateService.confirm(new Mate(sessionUid ,uid));
			if (confirmNum >=1)
				continue;
			// 친구상태인지 확인
			int confirmNum2 = mateService.confirm2(new Mate(sessionUid ,uid));
			if (confirmNum2 >=1)
				continue;
			
			// 성별
			String gender = ui.getGender();
			// 점수
			float uRating = ui.getuRating();
			// 거리계산
			double lat2 = ui.getuLat();
			double lng2 = ui.getuLng();
			double dist = mapUtill.distance(lat1, lng1, lat2, lng2);
			// 거리 필터링
			if (dist <= minDistance || maxDistance <= dist) {
				continue;
			}
			// km로 표기할지 m으로 표기할지 결정
			if (dist >= 1.0) {
				distance =  String.format("%.1f" , dist) + "km";
			} else {
				distance =  (int) (dist*1000) + "m";
			}
			
			// 나이계산
			int age = year - (ui.getBirthDate()/10000);

			// 관심운동 목록 가져오기
			String likeExercise = service.getLikeExercise(uid);
			List<String> likeExerList = exerciseUtill.findExercise(likeExercise);
			
			// 닉네임 가져오기
			String nickname = service.getNickname(uid);
			// 프로필사진 가져오기
			String uImage = service.getUimage(uid);
			
			// 일치하는 운동 계산(공백 + 2진수)
			String coincideNum = String.format("%12s", ui.getCoincideExer());
			
			// 알고리즘 점수 계산
			float score = (float) (exerciseUtill.countOne(coincideNum)*30 + uRating*10 - dist);
			
			MatchingUsers matchingUser = new MatchingUsers(uid, nickname, uImage, distance, age, likeExerList, gender, uRating, score);
			matchingList.add(matchingUser);
		}
		
		// score를 기준으로 내림차순 정렬
		Collections.sort(matchingList, (m1, m2) -> (int)(m2.getScore()- m1.getScore()));
		
		return matchingList;
	}
}

