package com.paypal.bfs.test.bookingserv.service.impl;

import com.paypal.bfs.test.bookingserv.dto.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import com.paypal.bfs.test.bookingserv.transformer.BookingTransformer;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

  private final BookingRepository repository;

  @Transactional
  @Override
  public Booking create(Booking booking) {

    BookingEntity bookingEntity = BookingTransformer.toBookingEntity(booking);

    BookingEntity bookingSaved = repository.save(bookingEntity);

    return BookingTransformer.toBookingDto(bookingSaved);
  }

  @Override
  public List<Booking> getAllBookings() {
    return repository.findAll().stream()
        .map(BookingTransformer::toBookingDto).collect(Collectors.toList());
  }
}
