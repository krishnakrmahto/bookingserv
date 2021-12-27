package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookingResourceImpl implements BookingResource {

    private final BookingService service;

    @Override
    public Booking create(Booking booking) {
        return service.create(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }
}
