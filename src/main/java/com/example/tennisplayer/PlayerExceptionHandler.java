package com.example.tennisplayer;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> handleException(PlayerNotFoundException exc, HttpServletRequest req) {
        PlayerErrorResponse error = new PlayerErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                req.getRequestURI(),
                exc.getMessage());
        return new ResponseEntity<>(error,  HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> genericHandler (PlayerBadRequestException ex, HttpServletRequest req){
        PlayerErrorResponse error = new PlayerErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                req.getRequestURI(),
                ex.getMessage());

        return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
    }
}
