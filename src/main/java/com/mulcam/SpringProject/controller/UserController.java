package com.mulcam.SpringProject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.User_info;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserSession userSession;
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/register")
	public String register() {
		return "user/register";
	}
	
	@PostMapping("/register")
	public String register2(HttpServletRequest req, Model model) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		String uname = req.getParameter("uname").strip();
		String nickname = req.getParameter("nickname").strip();
		String email = req.getParameter("email").strip();
		int email_check = Integer.parseInt(req.getParameter("email_check"));
		int birth_date = Integer.parseInt(req.getParameter("birth_date"));
		String gender_ = req.getParameter("gender");
		String u_addr = req.getParameter("addr").strip();
		String phoneNum = req.getParameter("phoneNum").strip();
		String[] likeExercise_ = req.getParameterValues("likeExercise");
		
		User u = service.getUser(uid);
		if (u != null) {
			model.addAttribute("msg", "중복 아이디입니다.");
			model.addAttribute("url", "/user/register");
			return "common/alertMsg";
		} 
		u = service.getEmail(email);
		if(u != null) {
			model.addAttribute("msg", "중복 이메일입니다.");
			model.addAttribute("url", "/user/register");
			return "common/alertMsg";
		}
		u = service.getNickname(nickname);
		if(u != null) {
			model.addAttribute("msg", "중복 닉네임입니다.");
			model.addAttribute("url", "/user/register");
			return "common/alertMsg";
		}
		u = service.getPhoneNum(phoneNum);
		if(u != null) {
			model.addAttribute("msg", "중복 전화번호 입니다.");
			model.addAttribute("url", "/user/register");
			return "common/alertMsg";
		}
		
		int like_exercise = 0;
		String gender = null;
		for (String i : likeExercise_) {
			like_exercise += Integer.parseInt(i);
		}
		if (gender_.equals("1") || gender_.equals("3")) {
			gender = "남";
		} else {
			gender = "여";
		}
		
		u = new User(uid, pwd, uname, phoneNum, nickname, email, email_check);
		service.register(u);
		User_info u_i = new User_info(uid, u_addr, like_exercise, birth_date, gender);
		service.register_info(u_i);

		return "user/login";
	}
	
	@GetMapping("/login")
	public String loginform() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest req, Model model, HttpSession session) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		int result = service.login(uid,pwd);
		switch (result) {
		case UserService.CORRECT_LOGIN :
			session.setAttribute("sessionUid", uid);
			session.setAttribute("sessionUname", userSession.getUname());
			return "redirect:/board/index";
		case UserService.UID_NOT_EXIST :
			model.addAttribute("msg", "아이디를 잘못입력하셧습니다. 다시 확인해주세요.");
			model.addAttribute("url", "/user/login");
			return "common/alertMsg";
		case UserService.WRONG_PASSWORD :
			model.addAttribute("msg", "비밀번호를 잘못입력하셧습니다. 다시 확인해주세요.");
			model.addAttribute("url", "/user/login");
			return "common/alertMsg";
		default:
			return "";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/board/index";
	}
}
