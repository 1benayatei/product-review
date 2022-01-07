package com.example.review.product.config.dto;

import com.example.review.product.config.ProductConfig;
import com.example.review.product.config.ProductConfig.Role;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Builder
@JsonAutoDetect(fieldVisibility = ANY)
public class ProductConfigDto {

    private Long id;
    private Long productId;
    private Boolean visible;
    private Boolean commentable;
    private Boolean votable;
    private Role commentRole;
    private Role voteRole;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductConfigDto of(ProductConfig productConfig) {
        return ProductConfigDto.builder()
                .id(productConfig.getId())
                .productId(productConfig.getProductId())
                .visible(productConfig.getVisible())
                .commentable(productConfig.getCommentable())
                .votable(productConfig.getVotable())
                .commentRole(productConfig.getCommenterRole())
                .voteRole(productConfig.getVoterRole())
                .createdAt(productConfig.getCreatedAt())
                .updatedAt(productConfig.getUpdatedAt())
                .build();
    }
}
