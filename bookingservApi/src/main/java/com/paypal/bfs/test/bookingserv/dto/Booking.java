package com.paypal.bfs.test.bookingserv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
@Data
@Builder
public class Booking {

  private Integer id;

  @JsonProperty("first_name")
  @NotNull
  private String firstName;

  @JsonProperty("last_name")
  @NotNull
  private String lastName;

  @JsonProperty("date_of_birth")
  private Date dateOfBirth;

  @JsonProperty("checkin_datetime")
  private Date checkinDatetime;

  @JsonProperty("checkout_datetime")
  private Date checkoutDatetime;

  @JsonProperty("total_price")
  private Double totalPrice;

  @JsonProperty("deposit")
  private Double deposit;

  @JsonProperty("address")
  private Address address;
}
