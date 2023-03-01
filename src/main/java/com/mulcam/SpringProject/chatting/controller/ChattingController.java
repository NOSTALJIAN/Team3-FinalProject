package com.mulcam.SpringProject.chatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.SpringProject.chatting.ChattingMessage;
import com.mulcam.SpringProject.chatting.dao.ChattingHistoryDAO;
import com.mulcam.SpringProject.chatting.service.Receiver;
import com.mulcam.SpringProject.chatting.service.Sender;

@Controller
public class ChattingController {

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;
    
    @Autowired
    private ChattingHistoryDAO chattingHistoryDAO;
    
    private static String BOOT_TOPIC = "kafka-chatting";

    /*
     * "url/app/message"로 들어오는 메세지를 "/topic/public"을 구독하는 사람들에게 송신
     */
    @MessageMapping("/message")
    @SendTo("/topic/public")
    public void sendMessage(ChattingMessage message) throws Exception {
    	message.setTimeStamp(System.currentTimeMillis());
    	chattingHistoryDAO.save(message);
    	sender.send(BOOT_TOPIC, message);
    }
    
    @MessageMapping("/file")
    @SendTo("/topic/chatting")
    public ChattingMessage sendFile(ChattingMessage message) throws Exception {
    	return new ChattingMessage(message.getFileName(), message.getRawData(), message.getUser());
    }

    @RequestMapping("/history")
    public List<ChattingMessage> getChattingHistory() throws Exception {
        System.out.println("History");
        return chattingHistoryDAO.get();
    }

}