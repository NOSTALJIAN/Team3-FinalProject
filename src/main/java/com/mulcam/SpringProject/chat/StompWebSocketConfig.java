package com.mulcam.SpringProject.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Profile("stomp")
@Configuration
@EnableWebSocketMessageBroker	//	Stomp를 사용하기 위해 선언하는 어노테이션
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	registry.addEndpoint("/stomp/chat")
    	.setAllowedOriginPatterns("*://*:8080", "*://*:8090",  "*://*.*.*.*:8080", "*://*.*.*.*:8090")
    	.withSockJS();
//		.setClientLibraryUrl("https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js");
    }
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	config.setApplicationDestinationPrefixes("/pub");	//	->	Client에서 SEND 요청을 처리
    	config.enableSimpleBroker("/sub");	//	->	해당 경로로 SimpleBroker를 등록, SimpleBroker는 해당하는 경로를 SUBSCRIBE하는 Client에게 메세지를 전달
    	
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