package com.paypal.bfs.test.bookingserv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {

  private String line1;

  private String line2;

  private String city;

  private String state;

  @JsonProperty("zip_code")
  private String zipCode;
}
