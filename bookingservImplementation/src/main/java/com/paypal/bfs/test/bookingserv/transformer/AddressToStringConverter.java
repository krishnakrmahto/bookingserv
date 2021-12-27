package com.paypal.bfs.test.bookingserv.transformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.bookingserv.dto.Address;
import java.io.IOException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import lombok.AllArgsConstructor;

@Converter
@AllArgsConstructor
public class AddressToStringConverter implements AttributeConverter<Address, String> {

  private final ObjectMapper objectMapper;

  @Override
  public String convertToDatabaseColumn(Address address) {
    try {
      return objectMapper.writeValueAsString(address);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed to convert Address to String");
    }
  }

  @Override
  public Address convertToEntityAttribute(String address) {
    try {
      return objectMapper.readValue(address, Address.class);
    } catch (IOException e) {
      throw new RuntimeException("Failed to convert String to Address");
    }
  }
}
