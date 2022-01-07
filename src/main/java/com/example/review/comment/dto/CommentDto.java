package com.example.review.comment.dto;

import com.example.review.comment.Comment;
import com.example.review.comment.Comment.CommentStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Builder
@JsonAutoDetect(fieldVisibility = ANY)
public class CommentDto {
    private Long id;
    private long productId;
    private long userId;
    private String text;
    private CommentStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommentDto of(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .productId(comment.getProductId())
                .userId(comment.getUserId())
                .text(comment.getText())
                .status(comment.getStatus())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
