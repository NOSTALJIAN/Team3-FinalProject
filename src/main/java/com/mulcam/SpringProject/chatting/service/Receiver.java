package com.mulcam.SpringProject.chatting.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mulcam.SpringProject.chatting.ChattingMessage;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Consumer
 */
@Service
public class Receiver {
	
	/**
	 * Kafka server로 부터 수신 할 수 있는 Receiver
	 * 메세지를 수신하여 연결된 client로 STOMP 프로토콜을 이용해 메세지를 송신
	 */
	
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private SimpMessagingTemplate template;
    
//    private CountDownLatch latch = new CountDownLatch(1);
//    public CountDownLatch getLatch() {	return latch;	}
    
//    @KafkaListener(topics = "${topic.boot}")
    @KafkaListener(id = "main-listener", topics = "kafka-chatting")
    public void receive(ChattingMessage message) throws Exception {
    	LOGGER.info("message='{}'", message);
    	HashMap<String, String> msg = new HashMap<>();
        msg.put("timestamp", Long.toString(message.getTimeStamp()));
        msg.put("message", message.getMessage());
        msg.put("author", message.getUser());
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(msg);
        
        System.out.println("@@@@@@@@@@@@@" + json);
        this.template.convertAndSend("/topic/public", json);
    }
    
    //    public void receive(ConsumerRecord<?, ?> consumerRecord) throws Exception {
//    	LOGGER.info("received data='{}'", consumerRecord.toString());
//    	String[] message = consumerRecord.value().toString().split("\\|");
//    	LOGGER.info("message='{}'", Arrays.toString(message));
//    	this.template.convertAndSend("/topic/chatting", new ChattingMessage(message[0], message[1]));
//    	latch.countDown();
//    }
}