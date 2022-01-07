package com.example.review.product.config.exception;

import com.example.review.common.exception.AbstractBadRequestException;

public class ProductConfigAlreadyExistsException extends AbstractBadRequestException {
    @Override
    public String getCode() {
        return "PRODUCT_CONFIG_ALREADY_EXISTS";
    }
}
