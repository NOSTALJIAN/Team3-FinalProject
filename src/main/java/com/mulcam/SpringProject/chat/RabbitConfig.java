package com.mulcam.SpringProject.chat;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
@EnableRabbit
public class RabbitConfig {
	
	private final static String CHAT_QUEUE_NAME = "chat.queue";
	private final static String CHAT_EXCHANGE_NAME = "chat.exchange";
	private static final String ROUTING_KEY = "room.*";

    //	Queue
    @Bean
    public Queue queue() {
        return new Queue(CHAT_EXCHANGE_NAME, true);
    }
    
    //	Exchange
    @Bean
    public TopicExchange exchange() {
    	return new TopicExchange(CHAT_EXCHANGE_NAME);
    }
    
    //	Exchange Queue 바인딩
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
    	return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    
    //	messageConverter를 커스터마이징하기 위함
    @Bean
    public RabbitTemplate rabbitTemplate() {
    	RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
    	rabbitTemplate.setMessageConverter(jsonMessageConverter());
    	rabbitTemplate.setRoutingKey(CHAT_QUEUE_NAME);
    	return rabbitTemplate;
    }
    
    @Bean
    public SimpleMessageListenerContainer container() {
    	SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    	container.setConnectionFactory(connectionFactory());
    	container.setQueueNames(CHAT_QUEUE_NAME);
    	container.setMessageListener(null);
    	return container;
    }
    
    @Bean
    public ConnectionFactory connectionFactory() {
    	CachingConnectionFactory factory = new CachingConnectionFactory();
    	factory.setHost("localhost");
    	factory.setUsername("guest");
    	factory.setPassword("guest");
    	return factory;
    }
    
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
    	objectMapper.registerModule(dateTimeModule());
    	
    	Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter(objectMapper);
    	
    	return converter;
    }
    
    @Bean
    public Module dateTimeModule() {
    	return new JavaTimeModule();
    }

}
