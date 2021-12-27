package com.paypal.bfs.test.bookingserv.transformer;

import com.paypal.bfs.test.bookingserv.dto.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;

public class BookingTransformer {

  public static BookingEntity toBookingEntity(Booking booking) {

    return BookingEntity.builder()
        .firstName(booking.getFirstName())
        .lastName(booking.getLastName())
        .dateOfBirth(booking.getDateOfBirth())
        .checkinDatetime(booking.getCheckinDatetime())
        .checkoutDatetime(booking.getCheckoutDatetime())
        .totalPrice(booking.getTotalPrice())
        .deposit(booking.getDeposit())
        .address(booking.getAddress())
        .build();
  }

  public static Booking toBookingDto(BookingEntity booking) {

    return Booking.builder()
        .id(booking.getId())
        .build();
  }

}
