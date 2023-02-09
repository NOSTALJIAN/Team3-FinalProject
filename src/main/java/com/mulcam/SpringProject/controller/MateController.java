package com.mulcam.SpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.SpringProject.entity.Mate;
import com.mulcam.SpringProject.service.MateService;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/mate")
public class MateController {
	@Autowired private UserSession userSession;	
	@Autowired private MateService service;
	
	/** 친구추가신청*/
	@ResponseBody
	@GetMapping("/addMate")
	public String MateAp(String receiveUser) {
		String user = userSession.getUid();
		// addMate 테이블에 uid, receiveUser적고 시간은 default로 보내줌
		
		Mate mate = new Mate(user, receiveUser);
		service.addMateAppl(mate);
		
		return "친구신청중";
	}
	
	/** 친구추가 취소*/
	@ResponseBody
	@GetMapping("/mateCancle")
	public String mateCancle(String receiveUser) {
		String user = userSession.getUid();
		
		Mate mate = new Mate(user, receiveUser);
		service.mateCancle(mate);
		return "친구신청";
	}
	
	/** 친구추가 거절*/
	@ResponseBody
	@GetMapping("/mateReject")
	public void mateReject(String receiveUser) {
		String user = userSession.getUid();
		Mate mate = new Mate(receiveUser, user);
		service.mateCancle(mate);
	}
	
	/** 친구추가 수락*/
	@ResponseBody
	@GetMapping("/mateAccept")
	public void mateAccept(String receiveUser) {
		String user = userSession.getUid();
		Mate mate = new Mate(receiveUser, user);
		service.mateAccept(mate);
	}
	
	
	/** 친구추가 보낸창 */
	@GetMapping("/addMateForm")
	public String addMateForm(Model model) {
		String uid = userSession.getUid();
		List<Mate>  mateList = service.getAddMate(uid);
		model.addAttribute("addMateList", mateList);
		return "mate/addMateForm";
	}
	
	
	/** 친구추가 수락/거절창 */
	@GetMapping("/receiveMateForm")
	public String receiveMateForm(Model model) {
		String uid = userSession.getUid();
		List<Mate>  mateList = service.getReceiveMate(uid);
		model.addAttribute("receiveMateList", mateList);
		return "mate/receiveMateForm";
	}
	
	
	/** 친구창 */
	@GetMapping("/mateForm")
	public String mateForm(Model model) {
		// 가져와야할 데이터 userRelationship테이블에서
		// 1로 relationship에서 1인것들 가져오기
		String uid = userSession.getUid();
		List<String> mateList = service.getMateList(uid);
		model.addAttribute("mateList", mateList);
		return "mate/mateForm";
	}
	
}
