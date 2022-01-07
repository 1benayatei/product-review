package com.example.review.product.config;


public interface ProductConfigService {
    ProductConfig create(ProductConfig productConfig);

    ProductConfig update(long id, ProductConfig productConfig);

    ProductConfig getById(long id);

    ProductConfig getByProductId(long id);
}
