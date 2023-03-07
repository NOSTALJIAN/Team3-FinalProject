package com.mulcam.SpringProject.chatting.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mulcam.SpringProject.chatting.entity.ChatRoomVO;
import com.mulcam.SpringProject.chatting.entity.MessageVO;
import com.mulcam.SpringProject.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
public class ChatDAOImpl implements ChatDAO {
	
	@Autowired private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public ChatRoomVO selectChatRoom(String roomId) {
		return sqlSession.selectOne("mapper.chat.selectChatRoom", roomId);
	}
	
	@Override
	public int insertMessage(MessageVO chatMessage) {
		return sqlSession.insert("mapper.chat.insertMessage", chatMessage);
	}
	
	@Override
	public List<MessageVO> messageList(String roomId) {
		return sqlSession.selectList("mapper.chat.messageList", roomId);
	}

	@Override
	public int createChat(ChatRoomVO room) {
		return sqlSession.insert("mapper.chat.createChat", room);
	}

	@Override
	public ChatRoomVO searchChatRoom(ChatRoomVO room) {
		return sqlSession.selectOne("mapper.chat.searchChatRoom", room);
	}

	@Override
	public List<ChatRoomVO> chatRoomList(String user_id) {
		return sqlSession.selectList("mapper.chat.chatRoomList", user_id);
	}

	@Override
	public int selectUnReadCount(MessageVO message) {
		return sqlSession.selectOne("mapper.chat.selectUnReadCount",message);
	}

	@Override
	public int updateCount(MessageVO message) {
		return sqlSession.update("mapper.chat.updateCount", message);
	}

	@Override
	public void deleteRoom(String roomId) {
		sqlSession.delete("mapper.chat.deleteRoom", roomId);
	};

	public User checkUserWithSessionKey(String sessionId) {
		return sqlSession.selectOne("mapper.chat.checkUserWithSessionKey", sessionId);
	}
}
