package com.example.review.comment.exception;

import com.example.review.common.exception.AbstractBadRequestException;

public class CommentNotAllowedException extends AbstractBadRequestException {
    @Override
    public String getCode() {
        return "COMMENT_NOT_ALLOWED";
    }
}
