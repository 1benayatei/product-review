package com.example.review.vote;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long userId;
    private Short score;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public Vote(long productId, long userId, short score) {
        this.productId = productId;
        this.userId = userId;
        this.score = score;
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
