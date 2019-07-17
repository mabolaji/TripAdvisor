//package com.mum.ea.project.carRental.listener;
//
//import com.mum.ea.project.carRental.Model.Car;
//import com.mum.ea.project.carRental.Model.CarBookingRecord;
//import com.mum.ea.project.carRental.Service.CarBookingService;
//import com.mum.ea.project.carRental.Service.CarService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Calendar;
//
//@Component
//@RabbitListener(queues = {"car_booking_queue"})
//public class BookingListener {
//    private static final Logger LOGGER = LoggerFactory.getLogger(BookingListener.class);
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//    private static final String EXCHANGE = "travel_advisory";
//    private static final String ROUTING_KEY = "car_booking_queue";
//
//    @Autowired
//    private CarBookingService bookingService;
//    @Autowired
//    private CarService carService;
//
//    @RabbitHandler
//    public void receiveMessage(Booking booking) {
//
//        LOGGER.info(" receive car booking : " + booking.toString());
//        try {
//
//            Car car = carService.getCar(booking.getCarId());
//            CarBookingRecord bookingRecord = new CarBookingRecord();
//            bookingRecord.setCar(car);
//            bookingRecord.setDropDate(booking.getEndDate());
//            bookingRecord.setPickdate(booking.getStartDate());
//            bookingRecord.setEmail(booking.getEmail());
//
//            bookingService.add(bookingRecord);
//            //send email to customer
//            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, getEmail(booking.getEmail()));
//            //todo : send email to Airline
//        } catch (Exception ex) {
//            LOGGER.error(ex.toString());
//        }
//
//    }
//
//    private Email getEmail(String mail) {
//        Email email = new Email();
//        email.setBody("sample car booking email body : " + Calendar.getInstance().toString());
//        email.setTitle("car booking email title" + Math.random());
//        email.setEmail(mail);
//        return email;
//    }
//}
//
