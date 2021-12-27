package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Override
    public Booking create(Booking booking) {
        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        return null;
    }
}
