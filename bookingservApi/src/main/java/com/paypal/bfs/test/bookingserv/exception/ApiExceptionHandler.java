package com.paypal.bfs.test.bookingserv.exception;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiException handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    log.error("Bad request received", e);
    FieldError fieldError = e.getBindingResult().getFieldError();
    String errorMessage = fieldError != null? fieldError.getField() + " " + fieldError.getDefaultMessage()
        : "Invalid request";

    return new ApiException(errorMessage, LocalDateTime.now());
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiException handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    log.error("Expected request body missing", e);
    return new ApiException("Booking data not found in request", LocalDateTime.now());
  }
}
