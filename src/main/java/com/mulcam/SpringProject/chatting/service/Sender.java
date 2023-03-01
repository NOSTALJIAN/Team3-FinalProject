package com.mulcam.SpringProject.chatting.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.mulcam.SpringProject.chatting.ChattingMessage;

/**
 * producer
 */
@Component
public class Sender {

	/**
	 * Kafka server로 메세지를 송신 할 수 있는 Sender
	 */
    
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, ChattingMessage> kafkaTemplate;

    public void send(String topic, ChattingMessage data){
        LOGGER.info("sending data='{}' to topic='{}'", data, topic);
        kafkaTemplate.send(topic, data);
    }

}