package com.example.review.product;

import com.example.review.comment.dto.CommentDto;
import com.example.review.product.config.dto.ProductConfigDto;
import com.example.review.product.dto.ProductDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.example.review.common.UrlMappings.API_V1_PRODUCT_GET;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(API_V1_PRODUCT_GET )
    @ResponseStatus(OK)
    public ProductDetailDto getProductDetail(@PathVariable long id) {
        var productDetail = productService.getDetail(id);

        return new ProductDetailDto(
                productDetail.comments().stream().map(CommentDto::of).toList(),
                productDetail.commentCount(),
                productDetail.productScore(),
                ProductConfigDto.of(productDetail.config())
        );
    }
}
