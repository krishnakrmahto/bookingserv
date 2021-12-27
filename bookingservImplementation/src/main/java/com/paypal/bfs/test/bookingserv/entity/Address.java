package com.paypal.bfs.test.bookingserv.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {

  private String line1;

  private String line2;

  private String city;

  private String state;

  @JsonProperty("zip_code")
  private String zipCode;
}
