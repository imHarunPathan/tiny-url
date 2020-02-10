package com.tinyUrl.exception.models;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author Harun Pathan
 * 08-02-2020
 */
public class ErrorModel {

    private String errorMessage;

    public ErrorModel() {
    }

    public ErrorModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
