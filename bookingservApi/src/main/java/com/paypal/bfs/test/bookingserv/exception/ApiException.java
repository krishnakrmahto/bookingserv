package com.paypal.bfs.test.bookingserv.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ApiException {
  String message;
  LocalDateTime timestamp;
}
