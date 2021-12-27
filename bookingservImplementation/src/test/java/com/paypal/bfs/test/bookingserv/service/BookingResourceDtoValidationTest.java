package com.paypal.bfs.test.bookingserv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.dto.Address;
import com.paypal.bfs.test.bookingserv.dto.Booking;
import com.paypal.bfs.test.bookingserv.impl.BookingResourceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class BookingResourceDtoValidationTest {

  @Mock
  private BookingService service;

  private MockMvc mockMvc;
  private String rootRequestMapping;

  private MediaType contentType;

  ObjectMapper objectMapper = new ObjectMapper();

  @Before
  public void setUp() throws Exception {
    BookingResource resource = new BookingResourceImpl(service);
    mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
    rootRequestMapping = "/v1/bfs/bookings";
    contentType = MediaType.APPLICATION_JSON;
  }

  @Test
  public void create_ReturnsHttpCreatedIfValidRequestDto() throws Exception {
    Booking validBooking = Booking.builder().id(1).firstName("First").lastName("Last").build();
    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(objectMapper.writeValueAsString(validBooking)))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullIdRequest() throws Exception {
    Booking bookingWithoutId = Booking.builder().firstName("First").lastName("Last").build();
    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(objectMapper.writeValueAsString(bookingWithoutId)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullFirstNameRequest() throws Exception {
    Booking bookingWithoutFirstName = Booking.builder().id(1).lastName("Last").build();
    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
        .contentType(contentType)
        .content(objectMapper.writeValueAsString(bookingWithoutFirstName)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullLastNameRequest() throws Exception {
    Booking bookingWithoutLastName = Booking.builder().id(1).firstName("First").build();
    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(objectMapper.writeValueAsString(bookingWithoutLastName)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullAddressLine1InRequest() throws Exception {
    Booking bookingWithoutAddressLine1 = Booking.builder()
        .id(1)
        .firstName("First")
        .lastName("Last")
        .address(Address.builder().city("City").state("State").zipCode("06555").build())
        .build();

    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(objectMapper.writeValueAsString(bookingWithoutAddressLine1)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullCityInRequest() throws Exception {
    Booking bookingWithoutAddressLine1 = Booking.builder()
        .id(1)
        .firstName("First")
        .lastName("Last")
        .address(Address.builder().line1("Line 1").state("State").zipCode("06555").build())
        .build();

    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(objectMapper.writeValueAsString(bookingWithoutAddressLine1)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullStateInRequest() throws Exception {
    Booking bookingWithoutAddressLine1 = Booking.builder()
        .id(1)
        .firstName("First")
        .lastName("Last")
        .address(Address.builder().line1("Line 1").city("City").zipCode("06555").build())
        .build();

    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(objectMapper.writeValueAsString(bookingWithoutAddressLine1)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullZipCodeInRequest() throws Exception {
    Booking bookingWithoutAddressLine1 = Booking.builder()
        .id(1)
        .firstName("First")
        .lastName("Last")
        .address(Address.builder().line1("Line 1").city("City").state("State").build())
        .build();

    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(objectMapper.writeValueAsString(bookingWithoutAddressLine1)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}
