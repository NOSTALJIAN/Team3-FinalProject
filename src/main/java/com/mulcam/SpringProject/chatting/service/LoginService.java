package com.mulcam.SpringProject.chatting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.controller.UserController;
import com.mulcam.SpringProject.dao.UserDao;
import com.mulcam.SpringProject.entity.User;

@Service
public class LoginService{

	@Autowired
	 UserController loginDAO;
	
	public User login(User vo) throws Exception {
		User returnVO = null;
		try {
			returnVO = loginDAO.readMemberWithIDPW(vo.getNickname(), vo.getPwd());
		} catch (Exception e) {
			e.printStackTrace();
			returnVO = null; //실행하다 문제가 생겼을때 해당 데이터를 보내지않겠다는 의미 = 예외처리
		}
		return returnVO;
	}
	
	public User getUserInfo(int id) throws Exception{
		return loginDAO.getUserInfo(id);
	}
	
	
	public int userIdCheck(String user_id) throws Exception {
		return loginDAO.checkOverId(user_id);
	}
	public List<User> userList() throws Exception {
		return loginDAO.userList();
	}
}
