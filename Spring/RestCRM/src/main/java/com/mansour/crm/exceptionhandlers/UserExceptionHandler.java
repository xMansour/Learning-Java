package com.mansour.crm.exceptionhandlers;

import com.mansour.crm.exceptions.UserException;
import com.mansour.crm.responseentities.UserResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserResponseEntity> handleUserNotFoundException(UserException e){
        UserResponseEntity userResponseEntity = new UserResponseEntity();
        userResponseEntity.setMessage(e.getMessage());
        userResponseEntity.setStatus(HttpStatus.NOT_FOUND.value());
        userResponseEntity.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(userResponseEntity, HttpStatus.NOT_FOUND);
    }


    //For generic exceptions
    @ExceptionHandler
    public ResponseEntity<UserResponseEntity> handleGenericExceptions(Exception e){
        UserResponseEntity userResponseEntity = new UserResponseEntity();
        userResponseEntity.setMessage(e.getMessage());
        userResponseEntity.setStatus(HttpStatus.BAD_REQUEST.value());
        userResponseEntity.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(userResponseEntity, HttpStatus.BAD_REQUEST);
    }
}
