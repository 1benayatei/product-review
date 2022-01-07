package com.example.review.comment.dto;

import com.example.review.comment.Comment;
import com.example.review.comment.Comment.CommentStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class CommentUpdateDto {
    @NotNull
    private CommentStatus status;

    public Comment toComment() {
        return new Comment(status);
    }
}
