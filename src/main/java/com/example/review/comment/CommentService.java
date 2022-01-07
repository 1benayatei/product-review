package com.example.review.comment;

import java.util.List;

public interface CommentService {
    Comment store(Comment comment);

    Comment update(Long id, Comment comment);

    long getCount(long productId);

    List<Comment> getLast3Comments(long productId);
}
