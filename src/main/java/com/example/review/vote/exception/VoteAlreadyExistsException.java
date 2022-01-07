package com.example.review.vote.exception;

import com.example.review.common.exception.AbstractBadRequestException;

public class VoteAlreadyExistsException extends AbstractBadRequestException {
    @Override
    public String getCode() {
        return "VOTE_ALREADY_EXISTS";
    }
}
