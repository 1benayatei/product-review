package com.example.review.common.exception;

public abstract class AbstractBadRequestException extends AbstractException {
    @Override
    public int getStatus() {
        return 400;
    }
}
