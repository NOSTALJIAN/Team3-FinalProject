package com.mulcam.SpringProject.chat;

import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Profile("stomp")
@Controller
@RequiredArgsConstructor
public class StompChatController {
	
	private final SimpMessagingTemplate template;	//	특정 Broker로 메세지를 전달
	
	/**
	 * Client가 SEND할 수 있는 경로
	 * stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합
	 * "/pub/chat/enter"
	 */
	@MessageMapping(value = "/chat/enter")
	public void enter(Message message) {
		message.setmContent(message.getmSender() + "님 입장!!!");
		template.convertAndSend("/sub/chat/room" + message.getCid(), message);
	}
	
	@MessageMapping(value = "/chat/message")
	public void message(Message message) {
		template.convertAndSend("/sub/chat/room" + message.getCid(), message);
	}
	
	/**
	 * @MessageMapping을 통해 WebSocket으로 들어오는 메세지 발행을 처리
	 * 
	 * Client에서는 prefix를 붙여서 "/pub/chat/enter"로 발행 요청을 하면,
	 * Controller가 해당 메세지를 받아서 처리
	 * 메세지가 발행되면 "/sub/chat/room/[cid]"로 메세지가 전송됨
	 * 
	 * Client에서는 해당 주소를 SUBSCRIBE하고 있다가 메세지가 전달되면 화면에 출력
	 * "/sub/chat/room/[cid]는 채팅방을 구분하는 값
	 */

}
