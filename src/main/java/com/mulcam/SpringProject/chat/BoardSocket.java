package com.mulcam.SpringProject.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/** WebSocket 호스트 설정 */
@ServerEndpoint("/boardsocket")
public class BoardSocket {
	
	//	접속 된 클라이언트 WebSocket session 관리 리스트
	private static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());
	
	//	메세지에서 유저 명을 얻기 위한 정규식
	private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");
	
	/**	WebSocket 으로 브라우저가 접속하면 요청되는 함수 */
	@OnOpen
	public void handleOpen(Session userSession) {
		//	클라이언트가 접속하면 WebSocket 세션을 리스트에 저장
		sessionUsers.add(userSession);
		//	콘솔에 접속 로그 출력
		System.out.println("client is now connected...");
	}
	
	/** WebSocket으로 메세지가 오면 요청되는 함수 */
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		//	메세지 내용 콘솔 출력
		System.out.println(message);
		//	초기 유저 명
		String name = "anonymous";
		//	메세지로 유저 명 추출
		Matcher matcher = pattern.matcher(message);
		//	메세지 예: {{유저명}}메세지
		if (matcher.find()) {
			name = matcher.group();
		}
		//	클로저를 위해 변수의 상수화
		final String msg = message.replaceAll(pattern.pattern(), "");
		final String username = name.replaceFirst("^\\{\\{", "").replaceFirst("\\}\\}$", "");
		//	session 관리 리스트에서 Session 취득
		sessionUsers.forEach(session -> {
			if (session == userSession) {
				return;
			}
			try {
				//	리스트에 있는 모든 세션(메세지를 보낸 유저는 제외)에 메시지를 보냄. {형식: 유저명 => 메세지}
				session.getBasicRemote().sendText(username + " => " + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	/** WebSocket과 브라우저가 접속이 끊기면 요청되는 함수 */
	@OnClose
	public void handleClose(Session userSession) {
		//	session 리스트로 접속을 끊은 세션을 제거함
		sessionUsers.remove(userSession);
		//	콘솔에 접속 끊김 로그 출력
		System.out.println("client is now disconnected...");
	}
}