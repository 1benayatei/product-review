package com.example.review.vote.dto;

import com.example.review.vote.Vote;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Builder
@JsonAutoDetect(fieldVisibility = ANY)
public class VoteDto {
    private Long id;
    private Long productId;
    private Long userId;
    private Short score;
    private LocalDateTime createdAt;

    public static VoteDto of(Vote vote) {
        return VoteDto.builder()
                .id(vote.getId())
                .productId(vote.getProductId())
                .userId(vote.getUserId())
                .score(vote.getScore())
                .createdAt(vote.getCreatedAt())
                .build();
    }
}
