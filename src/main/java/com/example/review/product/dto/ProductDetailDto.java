package com.example.review.product.dto;

import com.example.review.comment.dto.CommentDto;
import com.example.review.product.config.dto.ProductConfigDto;

import java.util.List;

public record ProductDetailDto(List<CommentDto> comments, long commentCount, float productScore,
                               ProductConfigDto config) {
}
