package com.mulcam.SpringProject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/register")
	public String register() {
		return "user/register";
	}
	
	@PostMapping("/register")
	public String register2(HttpServletRequest req, Model model) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		String pwd2 = req.getParameter("pwd2").strip();
		String uname = req.getParameter("uname").strip();
		String nickname = req.getParameter("nickname").strip();
		String email = req.getParameter("email").strip();
		int email_check = Integer.parseInt(req.getParameter("email_check"));
		String gender = req.getParameter("gender").strip();
		String addr = req.getParameter("addr").strip();
		String phoneNum = req.getParameter("phoneNum").strip();
		String[] likeExercise = req.getParameterValues("likeExercise");
		
		for (String i : likeExercise) {
			System.out.println(i);
		}
		
		return "user/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
}
