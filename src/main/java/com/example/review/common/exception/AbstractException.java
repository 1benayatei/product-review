package com.example.review.common.exception;

public abstract class AbstractException extends RuntimeException {
    public abstract String getCode();

    public abstract int getStatus();
}
