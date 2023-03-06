package com.mulcam.SpringProject.chatting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

import com.mulcam.SpringProject.chatting.domain.Message;
import com.mulcam.SpringProject.chatting.constants.KafkaConstants;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@RestController
public class ChatController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now().toString());
        try {
            //Sending the message to kafka topic queue
            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * WebSocket
     */
    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public Message broadcastGroupMessage(@Payload Message message) {
        //Sending this message to all the subscribers
        return message;
    }

    @MessageMapping("/newUser")
    @SendTo("/topic/group")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        // Add user in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

}

//package com.mulcam.SpringProject.chatting.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.web.bind.annotation.*;
//
//import com.mulcam.SpringProject.chatting.constants.KafkaConstants;
//import com.mulcam.SpringProject.chatting.model.Message;
//
//import java.time.LocalDateTime;
//import java.util.Random;



//import java.util.concurrent.ExecutionException;
//
//@RestController
//public class ChatController {
//
//    @Autowired
//    private KafkaTemplate<String, Message> kafkaTemplate;
////    private KafkaTemplate<String, String> kafkaTemplate;
//    
////    @GetMapping("/publish")
////    public String publish() {
////    	int leftLimit = 48;		//	numeral '0'
////    	int rightLimit = 122;	//	letter 'z'
////    	int targetStringLength = 10;
////    	Random random = new Random();
////    	
////    	String generatedString = random.ints(leftLimit, rightLimit + 1)
////    			.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
////    			.limit(targetStringLength)
////    			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
////    			.toString();
////    	
////    	this.kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, generatedString);
////    	
////    	return "success";
////    }
//
//    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
//    public void sendMessage(@RequestBody Message message) {
//        message.setTimestamp(LocalDateTime.now().toString());
//        try {
//            //Sending the message to kafka topic queue
//            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * WebSocket
//     */
//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/group")
//    public Message broadcastGroupMessage(@Payload Message message) {
//        //Sending this message to all the subscribers
//        return message;
//    }
//
//    @MessageMapping("/newUser")
//    @SendTo("/topic/group")
//    public Message addUser(@Payload Message message,
//                           SimpMessageHeaderAccessor headerAccessor) {
//        // Add user in web socket session
//        headerAccessor.getSessionAttributes().put("username", message.getSender());
//        return message;
//    }
//
//}