package com.example.review.comment.exception;

import com.example.review.common.exception.AbstractNotFoundException;

public class CommentNotFoundException extends AbstractNotFoundException {
    @Override
    public String getCode() {
        return "COMMENT_NOT_FOUND";
    }
}
