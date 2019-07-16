package com.project.tripadvisor.flightBooking.listener;


import com.project.tripadvisor.flightBooking.model.FlightBook;
import com.project.tripadvisor.flightBooking.service.FlightBookService;
import com.project.tripadvisor.flightBooking.service.serviceImpl.FlightBookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@RabbitListener(queues = {"flight_booking_queue"})
public class BookingListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingListener.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE = "travel_advisory";
    private static final String ROUTING_KEY = "flight_booking_queue";

    @Autowired
    private FlightBookService bookService;

    @RabbitHandler
    public void receiveMessage(Booking booking) {

        LOGGER.info(" receive flight booking : " + booking.toString());
        try {
            FlightBook flight = bookService.bookFlight(booking.getEmail(), booking.getFlightId());
            //send email to customer
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, getEmail(flight.getEmail()));
            //todo : send email to Airline
        } catch (Exception ex) {
            LOGGER.error(ex.toString());
        }

    }

    private Email getEmail(String mail) {
        Email email = new Email();
        email.setBody("sample flight booking email body : " + Calendar.getInstance().toString());
        email.setTitle("flight booking email title" + Math.random());
        email.setEmail(mail);
        return email;
    }
}
