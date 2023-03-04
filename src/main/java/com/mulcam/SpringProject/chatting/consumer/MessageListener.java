package com.mulcam.SpringProject.chatting.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.mulcam.SpringProject.chatting.constants.KafkaConstants;
import com.mulcam.SpringProject.chatting.domain.Message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
public class MessageListener {
	
    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void listen(Message message) {
        System.out.println("[ 메세지 전송 ] => " + message.getSender() + " : " + message.getContent());
        template.convertAndSend(KafkaConstants.TOPIC_GROUP_MESSAGE, message);
    }
}