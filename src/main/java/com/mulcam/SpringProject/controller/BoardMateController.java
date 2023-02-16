package com.mulcam.SpringProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.BoardMate;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;
import com.mulcam.SpringProject.service.BoardMateService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/group")
public class BoardMateController {
	@Autowired private UserSession userSession;	
	@Autowired private BoardMateService service;
	
	/** 운동 참가 신청*/
	@ResponseBody
	@GetMapping("/apply")
	public String apply(int bid, String receiveUser) {
		String user = userSession.getUid();
		
		BoardMate bMate = new BoardMate(bid, user, receiveUser);
		service.apply(bMate);
		return "참가신청중";
	}
	
	/** 운동 참가 취소*/
	@ResponseBody
	@GetMapping("/applyCancel")
	public String applyCancel(int bid, String receiveUser) {
		String user = userSession.getUid();
		
		BoardMate bMate = new BoardMate(bid, user, receiveUser);
		service.applyCancel(bMate);
		return "참가신청";
	}
	
	/** 운동 참가 거절*/
	@ResponseBody
	@GetMapping("/applyReject")
	public void applyReject(int bid, String receiveUser) {
		String user = userSession.getUid();
		
		BoardMate bMate = new BoardMate(bid, user, receiveUser);
		service.applyCancel(bMate);
	}
	
	/** 운동 참가 수락*/
	@ResponseBody
	@GetMapping("/applyAccept")
	public void applyAccept(int bid, String receiveUser) {
		String user = userSession.getUid();
		
		BoardMate bMate = new BoardMate(bid, user, receiveUser);
		service.applyAccept(bMate);
	}
	
	/** 운동 참가 보낸창 */
	@GetMapping("/applyForm")
	public String applyForm(Model model) {
		String uid = userSession.getUid();
		List<Board> applyList = service.getApplyList(uid);
		
		model.addAttribute("applyList", applyList);
		return "group/applyList";
	}
	
	/** 운동 참가 수락/거절창 */
	@GetMapping("/receiveForm")
	public String receiveForm(Model model) {
		String uid = userSession.getUid();
		List<UserInfo> receiveList = service.getReceiveList(uid);
		System.out.println(uid);
		System.out.println(receiveList);
		model.addAttribute("receiveList", receiveList);
		return "group/applyPerson";
	}
}
