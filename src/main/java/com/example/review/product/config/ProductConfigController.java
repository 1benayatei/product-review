package com.example.review.product.config;

import com.example.review.product.config.dto.ProductConfigCreationDto;
import com.example.review.product.config.dto.ProductConfigDto;
import com.example.review.product.config.dto.ProductConfigUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.example.review.common.UrlMappings.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ProductConfigController {

    private final ProductConfigService productConfigService;

    @PostMapping(API_V1_PRODUCT_CONFIG_CREATION)
    @ResponseStatus(CREATED)
    public ProductConfigDto create(@Valid @RequestBody ProductConfigCreationDto data) {
        var productConfig = data.toProductConfig();
        var createdProduct = productConfigService.create(productConfig);
        return ProductConfigDto.of(createdProduct);
    }

    @GetMapping(API_V1_PRODUCT_CONFIG_GET)
    @ResponseStatus(OK)
    public ProductConfigDto get(@PathVariable long id) {
        var product = productConfigService.getById(id);
        return ProductConfigDto.of(product);
    }

    @PatchMapping(API_V1_PRODUCT_CONFIG_UPDATE)
    @ResponseStatus(OK)
    public ProductConfigDto update(@PathVariable long id, @Valid @RequestBody ProductConfigUpdateDto data) {
        var updatedProduct = productConfigService.update(id, data.toProductConfig());
        return ProductConfigDto.of(updatedProduct);
    }
}
