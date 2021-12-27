package com.paypal.bfs.test.bookingserv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.bookingserv.api.BookingResource;
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
  private BookingResource resource;

  private MockMvc mockMvc;
  private String rootRequestMapping;
  private String validRequestJson;
  private String nullIdRequestJson;
  private String nullFirstNameRequestJson;
  private String nullLastNameRequestJson;

  private MediaType contentType;

  @Before
  public void setUp() throws Exception {
    resource = new BookingResourceImpl(service);
    mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
    rootRequestMapping = "/v1/bfs/bookings";

    Booking booking = Booking.builder().id(1).firstName("First").lastName("Last").build();
    Booking bookingWithoutId = Booking.builder().firstName("First").lastName("Last").build();
    Booking bookingWithoutFirstName = Booking.builder().id(1).lastName("Last").build();
    Booking bookingWithoutLastName = Booking.builder().id(1).firstName("First").build();

    ObjectMapper objectMapper = new ObjectMapper();
    validRequestJson = objectMapper.writeValueAsString(booking);
    nullIdRequestJson = objectMapper.writeValueAsString(bookingWithoutId);
    nullFirstNameRequestJson = objectMapper.writeValueAsString(bookingWithoutFirstName);
    nullLastNameRequestJson = objectMapper.writeValueAsString(bookingWithoutLastName);

    contentType = MediaType.APPLICATION_JSON;
  }

  @Test
  public void create_ReturnsHttpCreatedIfValidRequestDto() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(validRequestJson))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullIdRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(nullIdRequestJson))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullFirstNameRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
        .contentType(contentType)
        .content(nullFirstNameRequestJson))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void create_ReturnsHttpBadRequestIfNullLastNameRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post(rootRequestMapping)
            .contentType(contentType)
            .content(nullLastNameRequestJson))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}
