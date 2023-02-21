package com.mulcam.SpringProject.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	registry.addEndpoint("/chat/inbox")
    	.setAllowedOriginPatterns("*")
    	.addInterceptors(new StompHandshakeInterceptor())
    	.withSockJS()
    	.setDisconnectDelay(30 * 1000)
		.setClientLibraryUrl("https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js");
    }
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	registry.setApplicationDestinationPrefixes("/pub");	//	->	Client에서 SEND 요청을 처리
//    	registry.enableSimpleBroker("/sub");
    	
    	registry.setPathMatcher(new AntPathMatcher("."));	//	url을 chat/room/3 -> chat.room.3으로 참조하기 위해
    	registry.enableStompBrokerRelay("/sub", "/queue", "/topic", "/exchange", "/amq/queue")
    			.setRelayPort(61613)
    			.setSystemLogin("guest")
    			.setSystemPasscode("guess")
    			.setClientLogin("guest")
    			.setClientPasscode("guest");
    	
    	/**
    	 * "/pub" 경로로 시작하는 STOMP 메세지의 "destination" 헤더는
    	 * @Controller 객체의 @MessageMapping 메소드로 라우팅 됨
    	 * 
    	 * 내장된 메세지 브로커를 사용해 Client에게 Subscriptions, Broadcasting 기능을 제공
    	 * "/sub" 로 시작하는 "destination" 헤더를 가진 메세지를 브로커로 라우팅 함
    	 * 
    	 * 내장된 Simple Message Broker는 "/sub" prefix에 대해 특별한 의미를 부여하지 않음
    	 */
    	
    }
}