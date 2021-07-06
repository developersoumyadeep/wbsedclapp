package com.falconworks.wbsedclapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class RESTExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exc) {
        List<String> messages = new ArrayList<>();
        messages.add(exc.getMessage());
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), messages, System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(OfficeNotFoundException exc) {
        List<String> messages = new ArrayList<>();
        messages.add(exc.getMessage());
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), messages, System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exc) {
        BindingResult bindingResult = exc.getBindingResult();
        List<String> messages = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(error->{messages.add(error.getField()+": "+error.getDefaultMessage());});
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), messages, System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(HttpMessageNotReadableException exc) {
        List<String> messages = new ArrayList<>();
        messages.add("Invalid request body");
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), messages, System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc) {
        List<String> messages = new ArrayList<>();
        messages.add(exc.getMessage()+" "+ Arrays.toString(exc.getStackTrace()));
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), messages, System.currentTimeMillis());
        if (exc instanceof AccessDeniedException) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(FeederNotFoundException exc) {
        List<String> messages = new ArrayList<>();
        messages.add(exc.getMessage());
        ErrorResponse response  = new ErrorResponse(HttpStatus.NOT_FOUND.value(), messages, System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
