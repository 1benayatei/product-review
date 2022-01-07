package com.example.review.comment.dto;

import com.example.review.comment.Comment;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class CommentCreationDto {

    @NotNull
    private Long productId;

    @NotNull
    private Long userId;

    @NotNull
    private String text;

    public Comment toComment() {
        return new Comment(productId, userId, text);
    }
}
