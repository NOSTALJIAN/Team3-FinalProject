package com.mulcam.SpringProject.chatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.mulcam.SpringProject.chatting.common.TeamColor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/stomp/chat")
				.setAllowedOriginPatterns("*")
				.withSockJS();
	}
	
	/*
	 * 어플리케이션 내부에서 사용할 path를 지정
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		log.debug(TeamColor.CSK + "configureMessageBroker");
		
		//	client에서 send 요청을 처리
		registry.setApplicationDestinationPrefixes("/pub");
		registry.enableSimpleBroker("/sub");
	}
}
