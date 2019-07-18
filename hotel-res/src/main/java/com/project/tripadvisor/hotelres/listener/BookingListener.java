package com.project.tripadvisor.hotelres.listener;


import com.project.tripadvisor.hotelres.domain.Hotel;
import com.project.tripadvisor.hotelres.domain.Reservation;
import com.project.tripadvisor.hotelres.domain.Room;
import com.project.tripadvisor.hotelres.service.HotelService;
import com.project.tripadvisor.hotelres.service.ReservationService;
import com.project.tripadvisor.hotelres.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@RabbitListener(queues = {"hotel_booking_queue"})
public class BookingListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingListener.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE = "travel_advisory";
    private static final String ROUTING_KEY = "hotel_booking_queue";

    @Autowired
    private ReservationService bookingService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomService roomService;

    @RabbitHandler
    public void receiveMessage(HotelBooking booking) {

        LOGGER.info(" receive  booking : " + booking.toString());
        try {

            Room room = roomService.findRoom(booking.getRoomId());

            Reservation bookingRecord = new Reservation();
            bookingRecord.setRoom(room);
            bookingRecord.setCheckIn(booking.getInDate());
            bookingRecord.setCheckOut(booking.getOutDate());
            bookingRecord.setEmail(booking.getEmail());

            bookingService.reserve(bookingRecord);
            //send email to customer
            rabbitTemplate.convertAndSend(EXCHANGE, "email_queue", getEmail(booking.getEmail()));
            //todo : send email to Airline
        } catch (Exception ex) {
            LOGGER.error(ex.toString());
        }

    }

    private Email getEmail(String mail) {
        Email email = new Email();
        email.setBody("sample car booking email body : " + Calendar.getInstance().toString());
        email.setTitle("car booking email title" + Math.random());
        email.setEmail(mail);
        return email;
    }
}
