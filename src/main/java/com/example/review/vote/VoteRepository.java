package com.example.review.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT avg (score) FROM Vote where productId = ?1")
    Optional<Float> getAverageScore(long productId);
}
