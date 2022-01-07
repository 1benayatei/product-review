package com.example.review.vote.dto;

import com.example.review.vote.Vote;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class VoteCreationDto {
    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private short score;

    @NotNull
    private Long productId;

    @NotNull
    private Long userId;

    public Vote toVote() {
        return new Vote(productId, userId, score);
    }
}
