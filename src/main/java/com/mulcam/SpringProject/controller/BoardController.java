package com.mulcam.SpringProject.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.devtools.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.service.BoardService;
import com.mulcam.SpringProject.service.JSONUtil;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bsv;
	@Value("{spring.servlet.multipart.location}") private String uploadDir;
	
	/** C : HOME 화면 */
	@GetMapping("/index")
	public String index() {
		return "board/index";
	}
	
	/** C : 게시물 목록 */
	@GetMapping("/list")
	public String list(HttpServletRequest req, Model model){
		List<Board> list = bsv.list();
		model.addAttribute("blist", list);
		return "board/list";
	}
	
	/** C : 게시물 디테일 */
//	@GetMapping("/detail/{bid}")
//	public String detail(@PathVariable int bid,HttpServletRequest req, Model model) {
//		Board board = bsv.detail(bid);
//		model.addAttribute("board", board);
//		return "board/detail";
//	}
	
	@GetMapping("/detail")
	public String detail(HttpServletRequest req, Model model) {
		int bid = Integer.parseInt(req.getParameter("bid"));
		String uid = req.getParameter("uid");
		String option = req.getParameter("option");
		HttpSession session = req.getSession();
		String sessionUid = (String) session.getAttribute("uid");
		
		// 조회수 증가. 단, 본인이 읽거나 댓글 작성후에는 제외.
		if (option == null && (!uid.equals(sessionUid))) 
			BoardService.increaseViewCount(bid);
		
		Board board = BoardService.insertBoard(bid);
		String jsonFiles = board.getB_files();
		if (!(jsonFiles == null || jsonFiles.equals(""))) {
			JSONUtil json = new JSONUtil();
			List<String> fileList = json.parse(jsonFiles);
			model.addAttribute("fileList", fileList);
		}
		model.addAttribute("board", board);
//		List<Reply> replyList = BoardService.getReplyList(bid);
//		model.addAttribute("replyList", replyList);
		
		return "board/detail";
	}
	
	/** C : 게시물 작성 */
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest req, LocalDateTime b_appointment) {
		String uid = req.getParameter("uid");
		String b_title = (String) req.getParameter("b_title");
		String b_category = (String) req.getParameter("b_category");
		int b_userCount =Integer.parseInt(req.getParameter("b_userCount"));
		String b_content = (String) req.getParameter("b_content");
		String b_location = (String) req.getParameter("b_location");
		
		List<MultipartFile> fileList = req.getFiles("b_files");
		List<String> list = new ArrayList<>();

		// File upload
		for (MultipartFile file: fileList) {
			list.add(file.getOriginalFilename());
			String uploadFile = uploadDir + "/" + file.getOriginalFilename();
			File fileName = new File(uploadFile);
			try {
				file.transferTo(fileName);
			} catch (Exception e) {
//						e.printStackTrace();
			}
		}
		JSONUtil json = new JSONUtil();
		String files = json.stringify(list);
		Board board = new Board(uid, b_title, b_category, b_userCount, b_content, b_appointment, b_location, files); 
		bsv.insertBoard(board);
		return "redirect:/board/list?p=1&f=&q=";
	}
			

}
