package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Airport;
import com.tripadvisor.integration.model.Booking;
import com.tripadvisor.integration.model.FlightDto;
import com.tripadvisor.integration.model.Restaurant;
import com.tripadvisor.integration.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Airport> getOrigins() {

        ResponseEntity<List<Airport>> response = restTemplate.exchange(Common.flight_origins_url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Airport>>() {
                });

        return response.getBody();

    }

    @Override
    public List<Airport> getDestinations(Long originId) {
        if (originId == null)
            return null;

        ResponseEntity<List<Airport>> response = restTemplate.exchange(Common.flight_destinations_url + originId, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Airport>>() {
                });

        return response.getBody();
    }

    @Override
    public List<FlightDto> getFlights(Booking booking) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String departureDate =  formatter.format(booking.getFrom());
        String url = Common.flight_search_url + "flightFilter?departure=" + booking.getOriginId() + "&arrival=" + booking.getDestinationId() + "&departureDate=" + departureDate;

        System.out.println(url);
        ResponseEntity<List<FlightDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<FlightDto>>() {
                });

        return response.getBody();
    }

    @Override
    public List<Restaurant> getRestaurants(Long flightId) {

        ResponseEntity<List<Restaurant>> response = restTemplate.exchange(Common.flight_restaurant_url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Restaurant>>() {
                });

        return response.getBody();
    }
}
