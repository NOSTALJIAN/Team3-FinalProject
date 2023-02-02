package com.mulcam.SpringProject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.SpringProject.entity.MatchingUsers;
import com.mulcam.SpringProject.misc.MatchingUtill;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/matching")
public class MatchingController {
	@Autowired private UserSession userSession;	
	@Autowired private MatchingUtill matchingUtill;
	
	
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
	
	@ResponseBody
	@GetMapping("/addMate")
	public String addMate(String receiveUser) {
		String user = userSession.getUid();
		
		
		return "친구신청중";
	}
	
	

}
