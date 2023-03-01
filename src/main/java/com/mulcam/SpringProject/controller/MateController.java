package com.mulcam.SpringProject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.SpringProject.entity.Mate;
import com.mulcam.SpringProject.misc.ExerciseUtill;
import com.mulcam.SpringProject.service.MateService;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/mate")
public class MateController {
	@Autowired private UserSession userSession;	
	@Autowired private MateService service;
	@Autowired private UserService userService;
	@Autowired private ExerciseUtill exerciseUtill;
	
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
	public void mateAccept(String receiveUser,Model model) {
		String user = userSession.getUid();
		Mate mate = new Mate(receiveUser, user);
		service.mateAccept(mate);
	}
	
	
	/** 친구추가 보낸창 */
	@GetMapping("/addMateForm")
	public String addMateForm(Model model) {
		String uid = userSession.getUid();
		// 관심운동 목록 제외한 필요데이터들 가져오기 (나이는 생년월일을 가져온다)
		List<Mate>  mateList1 = service.getAddMateList(uid);
		// 나이 계산을위해 필요
		int year =  LocalDate.now().getYear();
		
		List<Mate> addMateList = new ArrayList<>();
		for (Mate mate : mateList1) {
			// 생년월일을 나이로 변환
			int age = year - (mate.getAge()/10000);
			// 관심운동 목록 가져오기
			String likeExercise = userService.getLikeExercise(mate.getReceiveUser());
			List<String> likeExerList = exerciseUtill.findExercise(likeExercise);
			
			Mate mateInfo = new Mate(mate.getUid(), mate.getReceiveUser(), mate.getSendTime(), mate.getNickname(), mate.getuImage(),
					likeExerList, mate.getGender(), age);
			addMateList.add(mateInfo);
		}
		model.addAttribute("addMateList", addMateList);
		return "mate/addMateForm";
	}
	
	
	/** 친구추가 수락/거절창 */
	@GetMapping("/receiveMateForm")
	public String receiveMateForm(Model model) {
		String uid = userSession.getUid();
		// 관심운동 목록 제외한 필요데이터들 가져오기 (나이는 생년월일을 가져온다)
		List<Mate>  mateList1 = service.getReceiveMateList(uid);
		// 나이 계산을위해 필요
		int year =  LocalDate.now().getYear();
		
		List<Mate> receiveMateList = new ArrayList<>();
		for (Mate mate : mateList1) {
			// 생년월일을 나이로 변환
			int age = year - (mate.getAge()/10000);
			// 관심운동 목록 가져오기
			String likeExercise = userService.getLikeExercise(mate.getReceiveUser());
			List<String> likeExerList = exerciseUtill.findExercise(likeExercise);
			
			Mate mateInfo = new Mate(mate.getUid(), mate.getReceiveUser(), mate.getSendTime(), mate.getNickname(), mate.getuImage(),
					likeExerList, mate.getGender(), age);
			receiveMateList.add(mateInfo);
		}
		model.addAttribute("receiveMateList", receiveMateList);
		return "mate/receiveMateForm";
	}
	
	
	/** 친구창 */
	@GetMapping("/mateForm")
	public String mateForm(Model model) {
		// 가져와야할 데이터 userRelationship테이블에서
		// 1로 relationship에서 1인것들 가져오기
		String uid = userSession.getUid();
		List<Mate> mateList1 = service.getMateList(uid);
		// 나이 계산을위해 필요
		int year =  LocalDate.now().getYear();
		List<Mate> mateList = new ArrayList<>();
		for (Mate mate : mateList1) {
			// 생년월일을 나이로 변환
			int age = year - (mate.getAge()/10000);
			// 관심운동 목록 가져오기
			String likeExercise = userService.getLikeExercise(mate.getReceiveUser());
			List<String> likeExerList = exerciseUtill.findExercise(likeExercise);
			
			Mate mateInfo = new Mate(mate.getUid(), mate.getReceiveUser(), mate.getNickname(), mate.getuImage(),
					likeExerList, mate.getGender(), age);
			mateList.add(mateInfo);
		}
		
		model.addAttribute("mateList", mateList);
		return "mate/mateForm";
	}
	
	/** 친구삭제*/
	@ResponseBody
	@GetMapping("/mateDelete")
	public void mateDelete(String mateId) {
		String user = userSession.getUid();
		service.mateDelete(user, mateId);
	}
	
}
