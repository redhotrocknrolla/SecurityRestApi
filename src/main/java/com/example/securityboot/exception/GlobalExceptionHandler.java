package com.example.securityboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserIncorrect> handleException(
            UserException exception) {
        UserIncorrect incorrect = new UserIncorrect();
        incorrect.setInfo(exception.getMessage());

        return new ResponseEntity<>(incorrect, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity <UserIncorrect> handleException(
            Exception exception) {
        UserIncorrect incorrect = new UserIncorrect();
        incorrect.setInfo(exception.getMessage());

        return new ResponseEntity<>(incorrect, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<RoleIncorrect> handleException (RoleException e) {
        RoleIncorrect roleIncorrect= new RoleIncorrect();
        roleIncorrect.setInfo(e.getMessage());

        return new ResponseEntity<>(roleIncorrect, HttpStatus.BAD_REQUEST);
    }
}
