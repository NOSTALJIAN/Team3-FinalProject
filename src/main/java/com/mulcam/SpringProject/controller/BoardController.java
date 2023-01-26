package com.mulcam.SpringProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bsv;

	@GetMapping("/index")
	public String index() {
		return "board/index";
	}
	
	@GetMapping("/list")
	public String list(HttpServletRequest req, Model model){
		List<Board> list = bsv.list();
		model.addAttribute("blist", list);
		return "board/list";
	}
	@GetMapping("/detail/{bid}")
	public String detail(@PathVariable int bid,HttpServletRequest req, Model model) {
		Board board = bsv.detail(bid);
		model.addAttribute("board", board);
		return "board/detail";
	}
}
