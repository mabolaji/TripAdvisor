package com.cs544.listener;

import com.cs544.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Test {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(Email.class);

    private static final String EXCHANGE = "travel_advisory";
    private static final String ROUTING_KEY = "email_queue";

   // @Scheduled(fixedRate = 10000)
    public void Test() {
        LOGGER.info("Sending sample email");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, getSampleEmail());
    }

    private Email getSampleEmail() {
        Email email = new Email();
        email.setBody("sample email body : " + Calendar.getInstance().toString());
        email.setTitle("email title"+ Math.random());
        email.setEmail("mabolaji@mum.edu");
        return email;
    }
}
