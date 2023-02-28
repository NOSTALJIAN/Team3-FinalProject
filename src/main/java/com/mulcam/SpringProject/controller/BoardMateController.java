package com.mulcam.SpringProject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.BoardMate;
import com.mulcam.SpringProject.entity.MatchingUsers;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;
import com.mulcam.SpringProject.misc.ExerciseUtill;
import com.mulcam.SpringProject.service.BoardMateService;
import com.mulcam.SpringProject.service.BoardService;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/group")
public class BoardMateController {
	@Autowired private UserSession userSession;	
	@Autowired private BoardMateService service;
	@Autowired private UserService userService;
	@Autowired private ExerciseUtill exerciseUtill;
	@Autowired private BoardService bsv;
	
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
		System.out.println(receiveList);
		
		List<MatchingUsers> applyUserInfoList = new ArrayList<>();
		// 오늘자 연도(나이계산을 위해서)
		int year =  LocalDate.now().getYear();
		
		for (BoardMate bm : receiveList) {
			// 운동 참가 신청한 uid
			String applyUid = bm.getUid();
			
			// 나이계산
			int age = year - (bm.getBirthDate()/10000);
			
			// 관심운동 목록 가져오기
			String likeExercise = userService.getLikeExercise(applyUid);
			List<String> likeExerList = exerciseUtill.findExercise(likeExercise);
			
			// 닉네임 가져오기
			String nickname = userService.getNickname(applyUid);
			// 프로필사진 가져오기
			String uImage = userService.getUimage(applyUid);
			
			MatchingUsers applyUserInfo = new MatchingUsers(applyUid, nickname, uImage, age, likeExerList);
			applyUserInfoList.add(applyUserInfo);
		}
		
		model.addAttribute("infoList", applyUserInfoList);
		System.out.println(applyUserInfoList);
		model.addAttribute("receiveList", receiveList);
		return "group/applyPerson";
	}
	
	/** 내가 쓴 게시글 보기 */
	@GetMapping("/myWrite")
	public String myWriteForm(HttpServletRequest req, Model model) {
		String uid = userSession.getUid();
		String page_ = req.getParameter("p");
		List<Board> myList = service.getMyList(uid);
		model.addAttribute("myList", myList);
		
		int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
		HttpSession session = req.getSession();
		session.setAttribute("currentBoardPage", page);
		
		int totalBoardNo = bsv.getBoardCount("bid", "");
		int totalPages = (int) Math.ceil(totalBoardNo / 10.);
		
		int startPage = (int)(Math.ceil((page-0.5)/10) - 1) * 10 + 1;
		int endPage = Math.min(totalPages, startPage + 9);
		List<String> pageList = new ArrayList<>();
		for (int i = startPage; i <= endPage; i++) 
			pageList.add(String.valueOf(i));
		model.addAttribute("pageList", pageList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPages", totalPages);
		
		String today = LocalDate.now().toString(); 
		model.addAttribute("today", today);
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
