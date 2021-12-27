package com.paypal.bfs.test.bookingserv.service;


import static org.mockito.Mockito.when;

import com.paypal.bfs.test.bookingserv.dto.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.service.impl.BookingServiceImpl;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {

  @Mock
  private BookingRepository repository;

  private BookingService service;

  @Before
  public void init() {
    service = new BookingServiceImpl(repository);
  }

  @Test
  public void createBooking_shouldReturnBookedBookingWithId() {

    when(repository.save(Mockito.any(BookingEntity.class))).thenReturn(BookingEntity.builder().id(1).build());

    Booking bookingResponse = service.create(Booking.builder().firstName("FirstName").lastName("LastName").build());
    Assertions.assertThat(bookingResponse.getId()).isNotNull();
  }

  @Test
  public void getAllBookings_shouldReturnAllBookingsWithId() {

    BookingEntity booking1 = BookingEntity.builder().id(1).build();
    BookingEntity booking2 = BookingEntity.builder().id(2).build();
    BookingEntity booking3 = BookingEntity.builder().id(3).build();

    when(repository.findAll()).thenReturn(Arrays.asList(booking1, booking2, booking3));

    service.getAllBookings().forEach(booking -> Assertions.assertThat(booking.getId()).isNotNull());
  }
}