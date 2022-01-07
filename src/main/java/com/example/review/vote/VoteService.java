package com.example.review.vote;

public interface VoteService {
    Vote store(Vote vote);

    float getAverageScore(long productId);
}
