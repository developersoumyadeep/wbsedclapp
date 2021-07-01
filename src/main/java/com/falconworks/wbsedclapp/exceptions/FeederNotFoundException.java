package com.falconworks.wbsedclapp.exceptions;

public class FeederNotFoundException extends RuntimeException{
    public FeederNotFoundException() {
    }

    public FeederNotFoundException(String message) {
        super(message);
    }

    public FeederNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeederNotFoundException(Throwable cause) {
        super(cause);
    }

    public FeederNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
