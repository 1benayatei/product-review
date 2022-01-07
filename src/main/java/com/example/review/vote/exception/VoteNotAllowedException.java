package com.example.review.vote.exception;

import com.example.review.common.exception.AbstractBadRequestException;

public class VoteNotAllowedException extends AbstractBadRequestException {
    @Override
    public String getCode() {
        return "VOTE_NOT_ALLOWED";
    }
}
