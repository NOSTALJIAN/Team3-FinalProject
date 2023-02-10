package com.mulcam.SpringProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.SpringProject.entity.MatchingCondition;
import com.mulcam.SpringProject.entity.MatchingUsers;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.misc.ExerciseUtill;
import com.mulcam.SpringProject.misc.MatchingUtill;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/matching")
public class MatchingController {
	@Autowired private UserSession userSession;	
	@Autowired private MatchingUtill matchingUtill;
	@Autowired private ExerciseUtill exerciseUtill;
	@Autowired private UserService service;
	
	
	/** 매칭 페이지*/
	@GetMapping("/list")
	public String register(HttpSession session, Model model) {
		// login안했으면 로그인페이지로(임시)
		if (userSession.getUid() == null)
			return "user/login";
		// 오늘자 연도(나이계산을 위해서)
		String sessionUid = userSession.getUid();
		
		// 매칭리스트 호출
		List<MatchingUsers> matchingList = matchingUtill.matchingList(sessionUid);
		
		model.addAttribute("matchingList", matchingList);
		return "matching/list";
	}
	
	
	/** 매칭조건 페이지*/
	@GetMapping("/condition")
	public String matchingConditionform(HttpSession session, Model model) {
		if (userSession.getUid() == null)
			return "user/login";
		// 1. 사용자의 userinfo에서 운동 목록 가져오기
		String uid = userSession.getUid();
		String likeExercise_  = service.getLikeExercise(uid);
		List<String> likeExercise = exerciseUtill.findExercise(likeExercise_);
		
		// 2. 사용자의 matchingCondition에서 정보가져오기
		MatchingCondition mC = service.getCondition(uid);
		if (mC == null) {
			mC = new MatchingCondition(uid ,likeExercise.get(0) , 10, 100, 0, 300, "모두");
		}
		
		model.addAttribute("likeExercise", likeExercise);
		model.addAttribute("mC", mC);
		// 		없다면 기본적인 조건 페이지 보여주기
		return "matching/condition";
	}
	
	@PostMapping("condition")
	public String matchingCondition(HttpServletRequest req, HttpSession session) {
		String uid = userSession.getUid();
		String bestExercise = req.getParameter("bestExercise");
		int minAge = Integer.parseInt(req.getParameter("minAge"));
		int maxAge = Integer.parseInt(req.getParameter("maxAge"));
		int minDistance = Integer.parseInt(req.getParameter("minDistance"));
		int maxDistance = Integer.parseInt(req.getParameter("maxDistance"));
		String pGender = req.getParameter("pGender");
		
		MatchingCondition mC_ = service.getCondition(uid);
		MatchingCondition mC = new MatchingCondition(uid, bestExercise, minAge, maxAge, minDistance, maxDistance, pGender);
		if (mC_ == null) {
			// 이전에 조건설정 안해놨으면 입력
			service.insertCondition(mC);
		} else {
			// 이전에 조건설정 해놨으면 수정
			service.updateCondition(mC);
		}
		
		return "redirect:/matching/list";
	}
}
