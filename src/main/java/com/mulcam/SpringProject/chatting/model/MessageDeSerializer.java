//package com.mulcam.SpringProject.chatting.model;
//
//import java.io.IOException;
//
//import org.apache.kafka.common.serialization.Deserializer;
//import org.jsoup.SerializationException;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.json.JsonMapper;
//
//public class MessageDeSerializer implements Deserializer<Message> {
//	
//	ObjectMapper mapper = JsonMapper.builder()
//			.findAndAddModules()
//			.build();
//
//	@Override
//	public Message deserialize(String topic, byte[] data) {
//		try {
//			return mapper.readValue(data, Message.class);
//		} catch (IOException e) {
//			throw new SerializationException(e);
//		}
//	}
//
//}
