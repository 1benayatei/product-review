package com.example.review.comment.exception;

import com.example.review.common.exception.AbstractBadRequestException;

public class CommentAlreadyAcceptedException extends AbstractBadRequestException {
    @Override
    public String getCode() {
        return "COMMENT_ALREADY_ACCEPTED";
    }
}
