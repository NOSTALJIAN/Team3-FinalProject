//package com.mulcam.SpringProject.chatting.controller;
//
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.mulcam.SpringProject.chatting.service.LoginService;
//import com.mulcam.SpringProject.entity.User;
//
//@Controller
//@RequestMapping("/basic")
//public class BasicController {
//
//	private static final Logger logger = LoggerFactory.getLogger(BasicController.class);
//	
//	@Autowired
//	LoginService loginService;
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "board/index";
//	}
//	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String list(HttpServletRequest request,Locale locale, Model model) throws Exception {
//		
//		HttpSession session = request.getSession();
//		User vo=new User();
//		vo.setUid((String)session.getAttribute("sessionUid"));
//		vo.setNickname((String)session.getAttribute("sessionNickname"));
//		session.setAttribute("login", vo);
//		
//		List<User> list = loginService.userList();
//		model.addAttribute("list", list);
//		return "board/list";
//	}
//	
//}
