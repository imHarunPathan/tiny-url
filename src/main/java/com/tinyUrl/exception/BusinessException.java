package com.tinyUrl.exception;

/**
 * @author Harun Pathan
 * 08-02-2020
 */
public class BusinessException extends RuntimeException {

    private final String errorMessage;

    public BusinessException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
