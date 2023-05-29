package com.mansour.springrest.exceptionhandlers;

import com.mansour.springrest.exceptions.UserNotFoundException;
import com.mansour.springrest.utils.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> userErrorHandler(UserNotFoundException e){
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setMessage(e.getMessage());
        userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        userErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> userErrorHandler(Exception e){
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setMessage(e.getMessage());
        userErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        userErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
