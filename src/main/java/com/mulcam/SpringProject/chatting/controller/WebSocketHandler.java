package com.mulcam.SpringProject.chatting.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mulcam.SpringProject.chatting.entity.ChatRoomVO;
import com.mulcam.SpringProject.chatting.entity.MessageVO;
import com.mulcam.SpringProject.chatting.service.ChatService;

@Controller
public class WebSocketHandler extends TextWebSocketHandler implements InitializingBean {
	
	@Autowired
	ChatService cService;
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	/* 채팅방 목록 <방 번호, ArrayList<session>> 이 들어감 */
	private Map<String, ArrayList<WebSocketSession>> RoomList = new ConcurrentHashMap<String, ArrayList<WebSocketSession>>();

	/* session, 방 번호 */
	private Map<WebSocketSession, String> sessionList = new ConcurrentHashMap<WebSocketSession, String>();
	
	private static int i;
	
	/** WebSocket 연결 성공 시 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		i++;
		System.out.println(session.getId() + " 연결 성공 !!! 총 접속 인원 : " + i + "명");
	}
	
	/** WebSocket 연결 종료 시 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		i--;
		System.out.println(session.getId() + " 연결 종료 ... 총 접속 인원 : " + i + "명");
		//	sessionList에 session이 있다면
		if(sessionList.get(session) != null) {
			//	session의 방 번호를 가져와서 방을 찾고, 그 방의 ArrayList<session>에서 해당 session을 지움
			RoomList.get(sessionList.get(session)).remove(session);
			sessionList.remove(session);
		}
	}
	
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//	전달받은 메세지
		String msg = message.getPayload();
		
		//	Json객체 -> Java객체
		//	출력값 ==> 
		MessageVO chatMessage = objectMapper.readValue(msg,  MessageVO.class);
		
		//	받은 메세지에 담긴 roomId로 채팅방 찾아오기
		ChatRoomVO chatRoom = cService.selectChatRoom(chatMessage.getRoom_id());
		System.out.println(chatMessage);
		System.out.println(chatRoom);
		
		//	채팅 세션 목록에 채팅방이 존재하지 않고, 처음 들어오고, DB에서의 채팅방이 있을 때
		//	채팅방 생성
		if(RoomList.get(chatRoom.getRoom_id()) == null && chatMessage.getMessage().equals("ENTER-CHAT") && chatRoom != null){

        // 채팅방에 들어갈 session들
        ArrayList<WebSocketSession> sessionTwo = new ArrayList<WebSocketSession>();
        // session 추가
        sessionTwo.add(session);
        // sessionList에 추가
        sessionList.put(session, chatRoom.getRoom_id());
        // RoomList에 추가
        RoomList.put(chatRoom.getRoom_id(), sessionTwo);
        // 확인용
        System.out.println("채팅방 생성");
	}
	
	    // 채팅방이 존재 할 때
		else if(RoomList.get(chatRoom.getRoom_id()) != null && chatMessage.getMessage().equals("ENTER-CHAT") && chatRoom != null) {
	        // RoomList에서 해당 방번호를 가진 방이 있는지 확인.
			RoomList.get(chatRoom.getRoom_id()).add(session);
	        // sessionList에 추가
			sessionList.put(session, chatRoom.getRoom_id());
	        // 확인용
	        System.out.println("생성된 채팅방으로 입장");
	    }
	    
	    // 채팅 메세지 입력 시
		else if(RoomList.get(chatRoom.getRoom_id()) != null && !chatMessage.getMessage().equals("ENTER-CHAT") && chatRoom != null) {
	        // 메세지에 보내는 사람, 내용 등을 담는다.
			TextMessage textMessage = new TextMessage(chatMessage.getUser_nickname() + "," + chatMessage.getUser_id() + "," + chatMessage.getMessage());
	        
	        // 현재 session 수
	        int sessionCount = 0;
	
	        // 해당 채팅방의 session에 뿌려준다.
	        for(WebSocketSession sess : RoomList.get(chatRoom.getRoom_id())) {
	            sess.sendMessage(textMessage);
	            sessionCount++;
	        }
	        
	        // 동적쿼리에서 사용할 sessionCount 저장
	        // sessionCount == 2 일 때는 unReadCount = 0,
	        // sessionCount == 1 일 때는 unReadCount = 1
	        chatMessage.setSessionCount(sessionCount);
	        
	        // DB에 저장한다.
	        int a = cService.insertMessage(chatMessage);
	        
	        if(a == 1) {
	            System.out.println("메세지 전송 및 DB 저장 성공");
	        }else {
	            System.out.println("메세지 전송 실패!!! & DB 저장 실패!!");
	        }
	    }
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {}
	
}
