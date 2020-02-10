package com.tinyUrl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tinyUrl.exception.models.ErrorModel;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Harun Pathan
 * 08-02-2020
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorModel> handleError(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(new ErrorModel(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}