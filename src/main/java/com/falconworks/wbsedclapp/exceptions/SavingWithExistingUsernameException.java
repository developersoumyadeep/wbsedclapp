package com.falconworks.wbsedclapp.exceptions;

public class SavingWithExistingUsernameException extends RuntimeException {
    public SavingWithExistingUsernameException() {
    }

    public SavingWithExistingUsernameException(String message) {
        super(message);
    }

    public SavingWithExistingUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public SavingWithExistingUsernameException(Throwable cause) {
        super(cause);
    }

    public SavingWithExistingUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
