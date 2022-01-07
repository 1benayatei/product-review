package com.example.review.product.config;

import com.example.review.product.config.exception.ProductConfigAlreadyExistsException;
import com.example.review.product.config.exception.ProductConfigNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultProductConfigService implements ProductConfigService {

    private final ProductConfigRepository productConfigRepository;

    @Override
    public ProductConfig create(ProductConfig productConfig) {
        var productConfigEntity = productConfigRepository.findByProductId(productConfig.getProductId());
        if (productConfigEntity.isPresent()) {
            throw new ProductConfigAlreadyExistsException();
        }
        return productConfigRepository.save(productConfig);
    }

    @Override
    public ProductConfig update(long id, ProductConfig data) {
        var productConfig = productConfigRepository.findById(id)
                .orElseThrow(ProductConfigNotFoundException::new);

        if (data.getVisible() != null) {
            productConfig.setVisible(data.getVisible());
        }
        if (data.getCommentable() != null) {
            productConfig.setCommentable(data.getCommentable());
        }
        if (data.getVotable() != null) {
            productConfig.setVotable(data.getVotable());
        }
        if (data.getCommenterRole() != null) {
            productConfig.setCommenterRole(data.getCommenterRole());
        }
        if (data.getVoterRole() != null) {
            productConfig.setVoterRole(data.getVoterRole());
        }
        return productConfigRepository.save(productConfig);
    }

    @Override
    public ProductConfig getById(long id) {
        return productConfigRepository.findById(id).orElseThrow(ProductConfigNotFoundException::new);
    }

    @Override
    public ProductConfig getByProductId(long productId) {
        return productConfigRepository.findByProductId(productId).orElseThrow(ProductConfigNotFoundException::new);
    }
}
