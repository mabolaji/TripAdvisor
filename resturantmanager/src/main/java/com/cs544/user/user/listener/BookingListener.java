package com.cs544.user.user.listener;

import com.cs544.user.user.model.BookingDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"restaurant_booking_queue"})//, "orders_queue", "deliveries_queue"
public class BookingListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingListener.class);

    @RabbitHandler
    public void receiveMessage(BookingDto data) {

        LOGGER.info(" restaurant_booking_queue receive message [" + data.toString() + "] ");
        try {
           //send email
        }
        catch (Exception ex){
            LOGGER.error(ex.toString());
        }
    }
}
