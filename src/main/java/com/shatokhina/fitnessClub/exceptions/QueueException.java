package com.shatokhina.fitnessClub.exceptions;

public class QueueException extends Exception {

    public QueueException(String message) { super(message); }

    public QueueException(String message, Throwable cause) { super(message, cause); }

    public QueueException(Throwable cause) { super(cause); }

    public QueueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}