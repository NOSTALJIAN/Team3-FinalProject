package com.mulcam.SpringProject.chatting.dao;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.mulcam.SpringProject.chatting.ChattingMessage;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// google cache 알아보기
@Component
public class ChattingHistoryDAO {

    private final Cache<UUID, ChattingMessage> chatHistoryCache = CacheBuilder
            .newBuilder()
            .maximumSize(50)	//	최대 50개
            .expireAfterWrite(30, TimeUnit.MINUTES)	//	30분 동안만 저장하도록
            .build();

    public void save(ChattingMessage chatObj){
        this.chatHistoryCache.put(UUID.randomUUID(), chatObj);
    }

    public List<ChattingMessage> get(){
        return chatHistoryCache.asMap().values().stream()
                .sorted(Comparator.comparing(ChattingMessage::getTimeStamp))
                .collect(Collectors.toList());
    }
}