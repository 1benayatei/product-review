package com.example.review.product.config.dto;

import com.example.review.product.config.ProductConfig;
import com.example.review.product.config.ProductConfig.Role;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class ProductConfigUpdateDto {

    private Boolean visible;
    private Boolean commentable;
    private Boolean votable;
    private Role commenterRole;
    private Role voterRole;

    public ProductConfig toProductConfig() {
        return ProductConfig.builder()
                .visible(visible)
                .commentable(commentable)
                .votable(votable)
                .commenterRole(commenterRole)
                .voterRole(voterRole)
                .build();
    }
}
