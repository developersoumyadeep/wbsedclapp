package com.falconworks.wbsedclapp.exceptions;

public class OfficeNotFoundException extends RuntimeException {
    public OfficeNotFoundException() {
    }

    public OfficeNotFoundException(String message) {
        super(message);
    }

    public OfficeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OfficeNotFoundException(Throwable cause) {
        super(cause);
    }

    public OfficeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
