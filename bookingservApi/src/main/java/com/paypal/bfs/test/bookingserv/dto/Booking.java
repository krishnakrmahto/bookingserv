package com.paypal.bfs.test.bookingserv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
@Data
@Builder
public class Booking {

  private Integer id;

  private String firstName;

  private String lastName;

  private Date dateOfBirth;

  private Date checkinDatetime;

  private Date checkoutDatetime;

  private Double totalPrice;

  private Double deposit;

  private Address address;
}
