package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.dto.Booking;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/bfs/bookings")
@Validated
public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Booking create(@RequestBody @Valid Booking booking);

    @GetMapping
    List<Booking> getAllBookings();
}
