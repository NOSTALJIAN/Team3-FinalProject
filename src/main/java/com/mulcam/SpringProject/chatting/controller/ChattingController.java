package com.mulcam.SpringProject.chatting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mulcam.SpringProject.chatting.ChattingMessage;
import com.mulcam.SpringProject.chatting.Receiver;
import com.mulcam.SpringProject.chatting.Sender;
import com.mulcam.SpringProject.chatting.dao.ChattingHistoryDAO;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ChattingController {

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Autowired
    private ChattingHistoryDAO chattingHistoryDAO;

    private static String BOOT_TOPIC = "kafka-chatting";

    @MessageMapping("/message")
    public void sendMessage(ChattingMessage message) throws Exception {
        message.setTimeStamp(System.currentTimeMillis());
        chattingHistoryDAO.save(message);
        sender.send(BOOT_TOPIC, message);
    }

    @GetMapping(value = "/history", produces = "application/json")
    public List<ChattingMessage> getChattingHistory() throws Exception {
        System.out.println("History");
        return chattingHistoryDAO.get();
    }

    @MessageMapping("/file")
    @SendTo("/topic/chatting")
    public ChattingMessage sendFile(ChattingMessage message) throws Exception{
        return new ChattingMessage(message.getFileName(), message.getRawData(), message.getUser());
    }

}