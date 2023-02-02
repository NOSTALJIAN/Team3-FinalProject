package com.mulcam.SpringProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;
import com.mulcam.SpringProject.misc.MapUtill;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Value("${naver.accessId}") private String accessId;	
	@Value("${naver.secretKey}") private String secretKey;
	

	@Autowired private UserSession userSession;	
	@Autowired private UserService service;
	@Autowired private MapUtill maputill;

	@GetMapping("/register")
	public String register() {
		return "user/register";
	}
	
	@PostMapping("/register")
	public String register2(HttpServletRequest req, Model model) throws Exception {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		String uname = req.getParameter("uname").strip();
		String nickname = req.getParameter("nickname").strip();
		String email = req.getParameter("email").strip();
		int emailCheck = Integer.parseInt(req.getParameter("emailCheck"));
		int birthDate = Integer.parseInt(req.getParameter("birthDate"));
		String gender = req.getParameter("gender");
		int uPostcode = Integer.parseInt(req.getParameter("postcode"));
		String uAddr = req.getParameter("addr").strip();
		String uDetailAddr = req.getParameter("detailAddr").strip();
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
		
		// 좋아하는 운동목록 숫자로 바꿔서 저장하기
		int likeExercise = 0;
		for (String i : likeExercise_) {
			likeExercise += Integer.parseInt(i);
		}
		
		// 유저의 주소에서 위도와 경도찾기
		
		List<Double> latlng = maputill.findLatLng(uAddr);
		double lat = latlng.get(0);
		double lng = latlng.get(1);
		
		u = new User(uid, pwd, uname, phoneNum, nickname, email, emailCheck);
		service.register(u);
		UserInfo ui = new UserInfo(uid, uPostcode, uAddr, uDetailAddr,likeExercise, birthDate, gender, lat, lng);
		service.register_info(ui);

		return "user/login";
	}
	
	//로그인
	@GetMapping("/login")
	public String loginform() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest req, Model model, HttpSession session) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		int result = service.login(uid, pwd);
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
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/board/index";
	}
	
	// 사용자 마이페이지
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		session.invalidate();
		return "user/mypage";
	}
}