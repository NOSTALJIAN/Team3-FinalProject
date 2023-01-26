package com.mulcam.SpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class BasicController {
	
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
	
	@GetMapping("/test")
	public String test() {
		return "board/test";
	}
}
