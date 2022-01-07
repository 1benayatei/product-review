package com.example.review.product.config.exception;

import com.example.review.common.exception.AbstractNotFoundException;

public final class ProductConfigNotFoundException extends AbstractNotFoundException {
    @Override
    public String getCode() {
        return "PRODUCT_CONFIG_NOT_FOUND";
    }
}
