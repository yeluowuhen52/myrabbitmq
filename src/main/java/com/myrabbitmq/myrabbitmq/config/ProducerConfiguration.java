package com.myrabbitmq.myrabbitmq.config;

/**
 * Description: myrabbitmq
 * Created by Jiang on 2020/6/29 23:02
 */

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

/**
 * Created by Thinkpad on 2015/8/4  22:05.
 */

/**
 * Created by Thinkpad on 2015/8/4  22:00.
 */
public class ProducerConfiguration {
    private String queueName;
    private String routingKey;
    private RabbitTemplate rabbitTemplate;
    private String exchange;
    private static CachingConnectionFactory connectionFactory;

    public ProducerConfiguration() {

    }

    public ProducerConfiguration(String exchange, String queueName, String routingKey) {
        this.queueName = queueName;
        this.routingKey = routingKey;
        this.exchange = exchange;
        this.rabbitTemplate = rabbitTemplate();
        RabbitAdmin admin = new RabbitAdmin(this.rabbitTemplate.getConnectionFactory());
        admin.declareQueue(new Queue(this.queueName));
        admin.declareExchange(new TopicExchange(exchange));
//        admin.setAutoStartup(true);
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getQueueName() {
        return queueName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//The routing key is set to the name of the queue by the broker for the default exchange.
        template.setRoutingKey(this.routingKey);
//Where we will synchronously receive messages from
        template.setDefaultReceiveQueue(this.queueName);
//        template.setMessageConverter(new JsonMessageConverter());
        return template;
    }

    public ConnectionFactory connectionFactory() {
        if (connectionFactory == null) {
            connectionFactory = new CachingConnectionFactory("localhost", 5672);
            connectionFactory.setUsername("guest");
            connectionFactory.setPassword("guest");
        }
        return connectionFactory;
    }

    public void send(String s) {
        this.rabbitTemplate.convertAndSend(s);
    }

    public void send(String exchange, String routingKey, Object msg) {
        this.rabbitTemplate.convertAndSend(exchange, routingKey, msg);
    }
}