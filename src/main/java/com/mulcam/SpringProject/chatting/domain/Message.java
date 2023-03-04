package com.mulcam.SpringProject.chatting.domain;

import java.io.Serializable;
import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String sender;
    private String content;
    private String timestamp;

}