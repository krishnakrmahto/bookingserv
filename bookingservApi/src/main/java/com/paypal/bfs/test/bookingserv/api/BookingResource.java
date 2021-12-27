package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.dto.Booking;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @PostMapping("/v1/bfs/bookings")
    Booking create(@RequestBody Booking booking);

    @GetMapping("/v1/bfs/bookings")
    List<Booking> getAllBookings();
}
