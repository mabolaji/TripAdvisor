package com.cs544.listener;

import com.cs544.domain.Booking;
import com.cs544.domain.Restaurant;
import com.cs544.model.BookingDto;
import com.cs544.model.Email;
import com.cs544.repository.IBookingRepository;
import com.cs544.repository.IResturantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@RabbitListener(queues = {"restaurant_booking_queue"})
public class BookingListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingListener.class);
    private static final String EXCHANGE = "travel_advisory";
    private static final String ROUTING_KEY = "email_queue";

    @Autowired
    private IBookingRepository bookingRepository;
    @Autowired
    private IResturantRepository resturantRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitHandler
    public void receiveMessage(BookingDto data) {

        LOGGER.info("restaurant_booking_queue receive message [" + data.toString() + "] ");
        try {
            Restaurant restaurant = resturantRepository.getOne(data.getRest_id());
            //save booking
            Booking booking = new Booking();
            booking.setCust_email(data.getCust_email());
            booking.setEndDate(data.getEndDate());
            booking.setRestaurant(restaurant);
            booking.setStartDate(data.getStartDate());

            bookingRepository.save(booking);
            //send email
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, getEmail(data.getCust_email()));
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, getEmail(restaurant.getManager_email()));
        } catch (Exception ex) {
            LOGGER.error(ex.toString());
        }
    }

    private Email getEmail(String mail) {
        Email email = new Email();
        email.setBody("sample restaurant email body : " + Calendar.getInstance().toString());
        email.setTitle("restaurant email title"+ Math.random());
        email.setEmail(mail);
        return email;
    }
}
