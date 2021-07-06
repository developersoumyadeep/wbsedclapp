package com.falconworks.wbsedclapp.exceptions;

public class RequestDTOValidationException extends RuntimeException {
    public RequestDTOValidationException() {
    }

    public RequestDTOValidationException(String message) {
        super(message);
    }

    public RequestDTOValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestDTOValidationException(Throwable cause) {
        super(cause);
    }

    public RequestDTOValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
