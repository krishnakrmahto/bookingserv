package com.paypal.bfs.test.bookingserv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Address {

  @NotEmpty
  private String line1;

  private String line2;

  @NotEmpty
  private String city;

  @NotEmpty
  private String state;

  @JsonProperty("zip_code")
  @NotEmpty
  private String zipCode;
}
