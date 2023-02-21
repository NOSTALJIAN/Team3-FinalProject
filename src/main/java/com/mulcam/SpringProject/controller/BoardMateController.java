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
		service.applyCancel2(bMate);
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
	@GetMapping("/applyList")
	public String applyForm(Model model) {
		String uid = userSession.getUid();
		List<Board> applyList = service.getApplyList(uid);
		
		System.out.println(applyList);
		model.addAttribute("applyList", applyList);
		return "group/applyList";
	}
	
	/** 운동 참가 수락/거절창 */
	@GetMapping("/applyPerson")
	public String receiveForm(HttpServletRequest req, Model model) {
		String uid = userSession.getUid();
		int bid = Integer.parseInt(req.getParameter("bid"));

		List<BoardMate> receiveList = service.getReceiveList(uid, bid);
		model.addAttribute("receiveList", receiveList);
		return "group/applyPerson";
	}
	
	/** 내가 쓴 게시글 보기 */
	@GetMapping("/myWrite")
	public String myWriteForm(Model model) {
		String uid = userSession.getUid();
		List<Board> myList = service.getMyList(uid);
		model.addAttribute("myList", myList);
		return "group/myWrite";
	}
	
	/** 신청 완료 게시글 목록 */
	@GetMapping("/applyDone")
	public String applyDoneForm(Model model) {
		String uid = userSession.getUid();
		List<Board> applyDoneList = service.getDoneList(uid);
		System.out.println(uid);
		System.out.println("***applyDoneList: " + applyDoneList);
		model.addAttribute("applyDoneList", applyDoneList);
		return "group/applyDone";
	}
}
