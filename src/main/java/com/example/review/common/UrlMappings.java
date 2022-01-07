package com.example.review.common;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class UrlMappings {

    public static final String API_V1 = "/api/v1";

    public static final String API_V1_PRODUCT_CONFIG = API_V1 + "/product-configs";
    public static final String API_V1_PRODUCT_CONFIG_CREATION = API_V1_PRODUCT_CONFIG;
    public static final String API_V1_PRODUCT_CONFIG_GET = API_V1_PRODUCT_CONFIG + "/{id}";
    public static final String API_V1_PRODUCT_CONFIG_UPDATE = API_V1_PRODUCT_CONFIG + "/{id}";

    public static final String API_V1_COMMENT = API_V1 + "/comments";
    public static final String API_V1_COMMENT_CREATION = API_V1_COMMENT;
    public static final String API_V1_COMMENT_UPDATE = API_V1_COMMENT + "/{id}";

    public static final String API_V1_VOTE = API_V1 + "/votes";
    public static final String API_V1_VOTE_CREATION = API_V1_VOTE;
    public static final String API_V1_PRODUCT_GET = API_V1 + "/products/{id}";
}
