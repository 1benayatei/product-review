package com.example.review.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    long countByProductId(long productId);

    List<Comment> findTop3ByProductIdOrderByCreatedAtDesc(long productId);
}
