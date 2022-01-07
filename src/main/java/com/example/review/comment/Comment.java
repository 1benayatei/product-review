package com.example.review.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.example.review.comment.Comment.CommentStatus.PENDING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private long productId;
    private long userId;
    private String text;
    @Enumerated(EnumType.STRING)
    private CommentStatus status = PENDING;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public Comment(long productId, long userId, String text) {
        this.productId = productId;
        this.userId = userId;
        this.text = text;
    }

    public Comment(CommentStatus status) {
        this.status = status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum CommentStatus {
        PENDING, ACCEPTED, REJECTED
    }
}
