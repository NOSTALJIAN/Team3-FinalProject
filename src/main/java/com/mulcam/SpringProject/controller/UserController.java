package com.mulcam.SpringProject.controller;

import java.io.File;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mulcam.SpringProject.entity.Mate;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.entity.UserInfo;
import com.mulcam.SpringProject.misc.ExerciseUtill;
import com.mulcam.SpringProject.misc.MapUtill;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Value("${naver.accessId}") private String accessId;	
	@Value("${naver.secretKey}") private String secretKey;
	@Value("${spring.servlet.multipart.location}") private String uploadDir;
	
	@Autowired private UserSession userSession;	
	@Autowired private UserService service;
	@Autowired private MapUtill mapUtill;
	@Autowired private ExerciseUtill eserciseUtill;
	
	/** 회원가입 페이지*/
	@GetMapping("/register")
	public String register() {
		return "user/register";
	}
	
	/** 회원가입 */
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
		List<Double> latlng = mapUtill.findLatLng(uAddr);
		double lat = latlng.get(0);
		double lng = latlng.get(1);
		
		u = new User(uid, pwd, uname, nickname, phoneNum, email, emailCheck);
		service.register(u);
		UserInfo ui = new UserInfo(uid, uPostcode, uAddr, uDetailAddr,likeExercise, birthDate, gender, lat, lng);
		service.registerInfo(ui);

		return "user/login";
	}
	
	/** 아이디,닉네임 중복체크*/
	@ResponseBody
	@GetMapping("/Duplication")
	public int idCheck(String data, String type) {
		User u = new User();
		if (type.equals("id")) {
			u = service.getUser(data);
		} else if (type.equals("nickname")) {
			u = service.CheckNickname(data);
		}
		// 중복일때는 1을 리턴 중복이 아닐때는 2를 리턴
		if (u != null) {
			return 1;
		} else 
			return 2;
	}
	
	/** 로그인 페이지 */
	@GetMapping("/login")
	public String loginform(HttpServletRequest req, HttpSession session) {
		//로그인하기전 페이지 주소 세션에 저장
		String prevPage="";
//		String confirm = (String) req.getParameter("confirm");
		String confirm = (req.getParameter("confirm")==null || req.getParameter("confirm")=="") ? "0" : req.getParameter("confirm");
		if (confirm.equals("0")) {	// 로그인 버튼을 눌러서 들어왔을경우
			prevPage = (String) req.getHeader("REFERER");
			if (prevPage == null) {	// 주소를 직접입력하여 들어왔을경우 board/index페이지로 이동
				prevPage = "http://localhost:8090/board/index";
			}
		} else {	// 운동친구눌러서 로그인 페이지 띄웠을경우
			prevPage = "http://localhost:8090/matching/list";
		}
		// 세션에 이전 페이지 저장(단, 로그인 실패시 세션에 새로 저장X)
		if (!(prevPage.contains("/user/login"))) { 
			// 앞에 http://localhost:8090제거
			String url = prevPage.substring(prevPage.lastIndexOf("8090")+4);
			userSession.setPrevPage(url);
		}
		return "user/login";
	}
	/** 로그인*/
	@PostMapping("/login")
	public String login(HttpServletRequest req, Model model, HttpSession session) {
		String uid = req.getParameter("uid").strip();
		String pwd = req.getParameter("pwd").strip();
		User user = service.getUser(uid);
		int result = service.login(uid, pwd);
		
		switch (result) {
		case UserService.CORRECT_LOGIN :
			// 이전페이지 불러오기
			String url = userSession.getPrevPage();
			if (url.equals(null))
				url = "/board/index";
			// 세션에 이름,아이디,닉네임 저장
			session.setAttribute("sessionUid", uid);
			session.setAttribute("sessionUname", userSession.getUname());
			session.setAttribute("sessionNickname", userSession.getNickname());
			model.addAttribute("msg", userSession.getNickname() + "님 환영합니다.");
			model.addAttribute("url", url);
			return "common/alertMsg";
		case UserService.UID_NOT_EXIST :
			model.addAttribute("msg", "아이디를 잘못입력하셧습니다. 다시 확인해주세요.");
			model.addAttribute("url", "/user/login");
			return "common/alertMsg";
		case UserService.WRONG_PASSWORD :
			model.addAttribute("msg", "비밀번호를 잘못입력하셧습니다. 다시 확인해주세요.");
			model.addAttribute("url", "/user/login");
			return "common/alertMsg";
		case UserService.UID_DELETE :
			model.addAttribute("msg", "탈퇴처리중인 회원입니다.");
			model.addAttribute("url", "/user/login");
			return "common/alertMsg";
		case UserService.UID_EXILE :
			model.addAttribute("msg", "추방된 회원입니다.");
			model.addAttribute("url", "/user/login");
			return "common/alertMsg";
		default:
			return "";
		}
	}
	
	/** 로그아웃*/
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/board/index";
	}	
	
	/** 사용자 페이지*/
	@GetMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
			if (userSession.getUid() == null)
				return "redirect:/user/login";
			String uid = userSession.getUid();
			
			User user = service.getUser(uid);
			UserInfo userInfo = service.getUserInfo(uid);
			String likeExercise = service.getLikeExercise(uid);
			List<String> likeExerList = eserciseUtill.findExercise(likeExercise);
			
			// 프로필 사진 가져오기
			String profileImg = service.getUimage(uid);
			model.addAttribute("user", user);
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("profileImg", profileImg);
			model.addAttribute("likeExerList", likeExerList);
			return "user/mypage";
		}

	/** 개인정보 수정 페이지*/
	@GetMapping("/update")
	public String updateForm(HttpSession session, Model model) {
		if (userSession.getUid() == null)
			return "redirect:/user/login";
		
		String uid = userSession.getUid();
		User user = service.getUser(uid);
		UserInfo userInfo = service.getUserInfo(uid);
		String likeExercise = service.getLikeExercise(uid);
		List<String> likeExerList = eserciseUtill.findExercise(likeExercise);
		
		model.addAttribute("user", user);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("likeExerList", likeExerList);
		
		return "user/update";
	}
	
	/** 개인정보 수정*/
	@PostMapping("/update")
	public String update(HttpSession session, HttpServletRequest req, Model model) throws Exception{
		String uid = userSession.getUid();
		String nickname = req.getParameter("nickname").strip();
		String email = req.getParameter("email").strip();
		int emailCheck = Integer.parseInt(req.getParameter("emailCheck"));
		int uPostcode = Integer.parseInt(req.getParameter("postcode"));
		String uAddr = req.getParameter("addr").strip();
		String uDetailAddr = req.getParameter("detailAddr").strip();
		String phoneNum = req.getParameter("phoneNum").strip();
		String[] likeExercise_ = req.getParameterValues("likeExercise");
		
		int likeExercise = 0;
		for (String i : likeExercise_) {
			likeExercise += Integer.parseInt(i);
		}
		
		List<Double> latlng = mapUtill.findLatLng(uAddr);
		double lat = latlng.get(0);
		double lng = latlng.get(1);
		
		User u = new User(uid, nickname, phoneNum, email, emailCheck);
		UserInfo ui = new UserInfo(uid, uPostcode, uAddr, uDetailAddr,likeExercise, lat, lng);
		service.update(u, ui);
		
		model.addAttribute("msg", "개인정보 수정이 완료되었습니다.");
		model.addAttribute("url", "/user/mypage");
		return "common/alertMsg";
	}
	
	/** 비밀번호 변경 페이지*/
	@GetMapping("/pwdUpdate")
	public String pwdUpdateForm() {
		if (userSession.getUid() == null)
			return "redirect:/user/login";
		return "user/pwdUpdate";
	}
	
	/** 비밀번호 변경*/
	@PostMapping("/pwdUpdate")
	public String pwdUpdate(HttpServletRequest req, HttpSession session, Model model) {
		String uid = userSession.getUid();
		String newpwd = req.getParameter("newpwd").strip();
		// 비밀번호 변경 실행
		service.updatePwd(uid, newpwd);
		
		model.addAttribute("msg", "비밀번호 변경이 완료되었습니다.");
		model.addAttribute("url", "/user/pwdUpdate");
		return "common/alertMsg";
	}
	
	/** ajax방식으로 비밀번호 일치하는지 확인하기 */
	@ResponseBody
	@GetMapping("/pwdConfirm")
	public int pwdConfirm(String pwd) {
		String uid = userSession.getUid();
		int result = service.login(uid, pwd);
		if (result == UserService.CORRECT_LOGIN) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/** 유저 프로필 페이지*/
	@GetMapping("/profile")
	public String profileForm(Model model) {
		if (userSession.getUid() == null)
			return "redirect:/user/login";
		String uid = userSession.getUid();
		
		// 프로필 사진 가져오기
		String profileImg = service.getUimage(uid);
		
		model.addAttribute("profileImg", profileImg);
		return "user/profile";
	}
	
	/** 유저 프로필 등록, 수정*/
	@PostMapping("/profile")
	public String profile(MultipartHttpServletRequest req, Model model) {
		String uid = userSession.getUid();
		MultipartFile file = req.getFile("regProfile");
		
		// 프로필 사진 경로 및 이미지 이름 새로정하기
		String fname = file.getOriginalFilename();
		String now = LocalDateTime.now().toString().substring(0,22).replaceAll("[-T:.]", "");
        int idx = fname.lastIndexOf('.');
        fname = now + fname.substring(idx);
		
		// 프로필 사진 저장
		File fileName = new File(uploadDir + "/" + fname);
		try {
			file.transferTo(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// DB에 파일 이름 저장
		service.profileUpload(uid, fname);
		
		return "redirect:/user/mypage";
	}
	
	/** 관리자 페이지*/
	@GetMapping("/admin")
	public String adminForm(Model model, HttpServletRequest req) {
		// 관리자가 아닐때 경고문구와 함께 홈화면으로 이동
		if (userSession.getUid() == null || !userSession.getUid().equals("admin")) {
			model.addAttribute("msg", "관리자 페이지입니다.");
			model.addAttribute("url", "/board/index");
			return "common/alertMsg";
		}
		List<User> userList = null;
		// 유저 정보 쭉가져오기(users만 가져오면될듯)
		String isDeleted_ = req.getParameter("isDeleted");
		if (isDeleted_ == null) {
			userList = service.getUserAllList();
			model.addAttribute("userList", userList);
			return "user/admin";
		}
		else {
			int isDeleted = Integer.parseInt(isDeleted_);
			userList = service.getUserList(isDeleted);
			model.addAttribute("userList", userList);
			return "user/admin";
		}
	}
	/** 회원 탈퇴/추방/탈퇴취소 처리*/
	@ResponseBody
	@GetMapping("/isDeleted")
	void IsDeleted(@RequestParam String uid,@RequestParam String isNum ) {
		int isDeleted = Integer.parseInt(isNum);
		service.userIsDeleted(uid, isDeleted);
	}
	
	/** 회원탈퇴 페이지  */
	@GetMapping("/delete")
	public String deleteForm() {
		return "user/delete";
	}
	
	@PostMapping("/delete")
	public String delete(HttpSession session) {
		String uid = userSession.getUid();
		service.userIsDeleted(uid, 1);
		session.invalidate();
		return "redirect:/board/index";
	}
	
	
	
}
