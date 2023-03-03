package com.mulcam.SpringProject.controller;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.Reply;
import com.mulcam.SpringProject.service.BoardService;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired private UserSession userSession;
	@Autowired private BoardService bsv;
	@Autowired private UserService service;
	
	@Value("${spring.servlet.multipart.location}") private String uploadDir;
	@Value("${kakao.AppKey}") private String kakaoAppKey;
	
	private String sportsArray[] = {"축구", "농구", "야구", "E-sports", "등산", "당구", "볼링", "사이클", "테니스", "조깅", "수영", "헬스"};
	
	/** HOME 화면 */
	@GetMapping("/index")
	public String index() {
		return "board/index";
	}
	
	/** 게시물 목록 */
	@GetMapping("/list")
	public String list(HttpServletRequest req, Model model){
//		List<Board> list = bsv.list();
		String page_ = req.getParameter("p");
		String field = req.getParameter("f");
		String query = req.getParameter("q");
		String period = req.getParameter("period");
		String sessionUid = userSession.getUid();
		
		LocalDate startDate = LocalDate.now();
		LocalDate endDate = null;
		
		// 일주일, 한달 내의 게시글만 보여주기
		if (period == null) {
			endDate = LocalDate.parse("2999-12-31");
		} else if (period.equals("week")) {
			endDate = startDate.plusWeeks(1);
		} else if (period.equals("month")) {
			endDate = startDate.plusMonths(1);
		} else {
			endDate = LocalDate.parse("2999-12-31");
		}
		
		int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
		field = (field == null || field.equals("")) ? "bCategory" : field;
		query = (query == null || query.equals("")) ? "" : query;
		List<Board> list = bsv.getBoardListByPeriod(page, field, query, startDate.toString(), endDate.toString(), sessionUid);
		
		HttpSession session = req.getSession();
		session.setAttribute("currentBoardPage", page);
		model.addAttribute("field", field);
		model.addAttribute("query", query);
		model.addAttribute("blist", list);
		model.addAttribute("sportsArray", sportsArray);
		model.addAttribute("uid", sessionUid);
		
		int totalBoardNo = bsv.getBoardCountByPeriod(field, query, startDate.toString(), endDate.toString(), sessionUid);
		int totalPages = (int) Math.ceil(totalBoardNo / 9.);
		
		int startPage = (int)(Math.ceil((page-0.5)/9) - 1) * 9 + 1;
		int endPage = Math.min(totalPages, startPage + 8);
		List<String> pageList = new ArrayList<>();
		for (int i = startPage; i <= endPage; i++) 
			pageList.add(String.valueOf(i));
		model.addAttribute("pageList", pageList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPages", totalPages);
		
		String today = LocalDate.now().toString(); 
		model.addAttribute("today", today);
		
		return "board/list";
	}
	
	/** 게시물 디테일 */
	@GetMapping("/detail")
	public String detail(HttpServletRequest req, Model model) {
		int bid = Integer.parseInt((String)req.getParameter("bid"));
		Board board = bsv.getBoard(bid);
		String uid = req.getParameter("uid");
		String option = req.getParameter("option");
		String nickname = service.getNickname(uid);
		model.addAttribute("b", board);
		model.addAttribute("n", nickname);
		model.addAttribute("kakaoAppKey", kakaoAppKey);
		String sessionUid = userSession.getUid();
		
		// 조회수 증가. 단, 본인이 읽거나 댓글 작성후에는 제외.
		if (option == null && (!uid.equals(sessionUid))) 
			bsv.increaseViewCount(bid);
		
		String jsonFiles = board.getbFiles();
	
	/*		 if (!(jsonFiles == null || jsonFiles.equals(""))) { JSONUtil json = new
			 JSONUtil(); List<String> fileList = json.parse(jsonFiles);
			 model.addAttribute("fileList", fileList); } */
		 
//		System.out.println(jsonFiles);
//		model.addAttribute("fileList", jsonFiles);
		model.addAttribute("b", board);
		
		// boardmate나 boardrelationship에 등록되어있는지 확인절차
		String state = bsv.getBoardState(sessionUid, bid);
		model.addAttribute("state", state);
		
		List<Reply> replyList = bsv.getReplyList(bid);
		model.addAttribute("replyList", replyList);

		return "board/detail";
	}
	
	/** 게시물 작성 */
	@GetMapping("/write")
	public String writeForm(Model model) {
		// login안했으면 로그인페이지로(임시)
		String uid = userSession.getUid();
		if (uid == null)
			return "redirect:/user/login";
		
		model.addAttribute("sportsArray", sportsArray);
		model.addAttribute("kakaoAppKey", kakaoAppKey);
		model.addAttribute("uploadDir", uploadDir);
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest req) throws Exception {
		String uid = req.getParameter("uid");
		String bTitle = (String) req.getParameter("bTitle");
		String bCategory = (String) req.getParameter("bCategory");
		int bUserCount =Integer.parseInt(req.getParameter("bUserCount"));
		LocalDateTime bAppointment = LocalDateTime.parse(req.getParameter("bAppointment").replace(" ", "T") + ":00");
		String bContent = (String) req.getParameter("bContent");
		String bLocation = (String) req.getParameter("bLocation");
		String bAddr = (String) req.getParameter("bAddr");

		// 썸네일 File upload 한개만
//		MultipartFile file = req.getFile("bFiles");
//		String fileName = file.getOriginalFilename();
//		String uploadFile = uploadDir + "/" + fileName;
//		file.transferTo(new File(uploadFile));
		
		Board board = new Board(uid, bTitle, bCategory, bUserCount, bContent, bAppointment, bLocation, bAddr); 
		bsv.insertBoard(board);
		return "redirect:/board/list";
	}
	
	/** 게시물 수정 */
	@GetMapping("/update")
	public String updateForm(HttpServletRequest req, Model model) {
		int bid = Integer.parseInt(req.getParameter("bid"));
		Board board = bsv.getBoard(bid);
		
		model.addAttribute("uploadDir", uploadDir);
		model.addAttribute("sportsArray", sportsArray);
		model.addAttribute("b", board);
		model.addAttribute("kakaoAppKey", kakaoAppKey);
		return "board/update";
	}
	
	@PostMapping("/update")
	public String update(MultipartHttpServletRequest req, Model model) throws Exception{
		int bid = Integer.parseInt(req.getParameter("bid"));
		String bTitle = (String) req.getParameter("bTitle");
		String bCategory = (String) req.getParameter("bCategory");
		int bUserCount =Integer.parseInt(req.getParameter("bUserCount"));
		String bContent = (String) req.getParameter("bContent");
		LocalDateTime bAppointment = LocalDateTime.parse(req.getParameter("bAppointment").replace(" ", "T") + ":00");
		String bLocation = (String) req.getParameter("bLocation");
		String bAddr = (String) req.getParameter("bAddr");
		String uid = (String) req.getParameter("uid");
		
		// 썸네일 File upload 한개만
//		MultipartFile file = req.getFile("bFiles");
//		String originName = req.getParameter("bFileName");
	//	String fileName = file.getOriginalFilename();
	//	if(fileName == null || fileName.equals("")) {
	//		fileName = originName;
	//	} else {
	//		String uploadFile = uploadDir + "/" + fileName;
	//		file.transferTo(new File(uploadFile));
	//	}
				
		Board board = new Board(bid, bTitle, bCategory, bUserCount, bContent, bAppointment, bLocation, bAddr); 
		bsv.updateBoard(board);
		
		return "redirect:/board/detail?bid=" + bid + "&uid=" + uid ;
	}
	
	/** 게시물 삭제 */
	@GetMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		int bid = Integer.parseInt(req.getParameter("bid"));
		model.addAttribute("bid", bid);
		return "board/delete";
	}
	
	@GetMapping("/deleteConfirm")
	public String deleteConfirm(HttpServletRequest req) {
		int bid = Integer.parseInt(req.getParameter("bid"));
		bsv.deleteBoard(bid);
		
		HttpSession session = req.getSession();
		return "redirect:/board/list?p=" + session.getAttribute("currentBoardPage") + "&f=&q=";
	}
	
	//=================================== 댓글 등록, 수정, 삭제===========================================	
	/** 댓글 등록 */
	@PostMapping("/reply")
	public String reply(HttpServletRequest req, Model model, HttpSession session) {
		String rContent = req.getParameter("rContent");
		int bid = Integer.parseInt(req.getParameter("bid"));
		String uid = req.getParameter("uid"); // 게시글의 uid
		int count = 1;
		
		// 게시글의 uid와 댓글을 쓰려고 하는 사람의 uid가 같으면 isMine이 1
		String sessionUid = userSession.getUid();
		int rIsMine = (uid.equals(sessionUid)) ? 1 : 0;
		
		Reply reply = new Reply(bid, sessionUid, rContent, rIsMine);
		bsv.insertReply(reply);
		bsv.increaseReplyCount(bid, count);
		return "redirect:/board/detail?bid=" + bid + "&uid=" + uid;
	}
	
	/** 댓글 수정 */
	@PostMapping("/replyUpdate")
	public String replyUpdate(HttpServletRequest req, Model model, HttpSession session) {
		String rContent = req.getParameter("rContent");
		int bid = Integer.parseInt(req.getParameter("bid"));
		String uid = req.getParameter("uid"); // 게시글의 uid
		int rid = Integer.parseInt(req.getParameter("rid"));
		
		// 게시글의 uid와 댓글을 쓰려고 하는 사람의 uid가 같으면 isMine이 1
		Reply reply = new Reply(rid, rContent);
		bsv.updateReply(reply);
		return "redirect:/board/detail?bid=" + bid + "&uid=" + uid;	
	}
	
	/** 댓글 삭제 */
	@GetMapping("/reply/delete")
	public String replyDelete(HttpServletRequest req, Model model) {
		String uid = req.getParameter("uid");
		int rid = Integer.parseInt(req.getParameter("rid"));
		int bid = Integer.parseInt(req.getParameter("bid"));
		
		int count = -1;
		bsv.deleteReply(rid);
		bsv.increaseReplyCount(bid, count);
		return "redirect:/board/detail?bid=" + bid + "&uid=" + uid;
	}

}