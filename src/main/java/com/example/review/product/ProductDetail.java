package com.example.review.product;

import com.example.review.comment.Comment;
import com.example.review.product.config.ProductConfig;

import java.util.List;

public record ProductDetail(List<Comment> comments, long commentCount, float productScore, ProductConfig config) {
}
