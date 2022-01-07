package com.example.review.comment.dto;

import com.example.review.comment.Comment;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class CommentCreationDto {

    @NotNull
    private Long productId;

    @NotNull
    private Long userId;

    @NotNull
    @Length(min = 10, max = 255)
    private String text;

    public Comment toComment() {
        return new Comment(productId, userId, text);
    }
}
