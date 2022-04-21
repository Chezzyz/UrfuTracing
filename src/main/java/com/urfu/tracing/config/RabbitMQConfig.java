package com.urfu.tracing.config;

import com.urfu.tracing.amqp.OrderAmqpProcessor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class RabbitMQConfig {

    static final String createOrderQueueName = "urfu-orders-create";

    static final String updateOrderStatusQueueName = "urfu-orders-update-status";

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(createOrderQueueName, updateOrderStatusQueueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(OrderAmqpProcessor receiver) {
        MessageListenerAdapter adapter = new MessageListenerAdapter(receiver);
        adapter.setQueueOrTagToMethodName(Map.ofEntries(
                Map.entry("urfu-orders-create", "receiveCreateMessage"),
                Map.entry("urfu-orders-update-status", "receiveUpdateStatusMessage")));

        return adapter;
    }

}
