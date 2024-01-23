package org.spring.calendar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CalendarExceptionHandler {
    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handleInvalidPasswordException(InvalidPasswordException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler(CalendarNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleCalenderNotFoundException(CalendarNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
