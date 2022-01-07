package com.example.review.product.dto;

import com.example.review.comment.dto.CommentDto;
import com.example.review.product.config.dto.ProductConfigDto;

import java.util.List;

public record ProductDetailDto(long commentCount, float productScore, List<CommentDto> comments,
                               ProductConfigDto config) {
}
