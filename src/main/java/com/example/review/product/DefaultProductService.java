package com.example.review.product;

import com.example.review.comment.CommentService;
import com.example.review.product.config.ProductConfigService;
import com.example.review.vote.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final VoteService voteService;
    private final CommentService commentService;
    private final ProductConfigService productConfigService;

    @Override
    public ProductDetail getDetail(long id) {
        var productConfig = productConfigService.getByProductId(id);
        var last3Comments = commentService.getLast3Comments(id);
        var productScore = voteService.getAverageScore(id);
        var commentCount = commentService.getCount(id);

        return new ProductDetail(last3Comments, commentCount, productScore, productConfig);
    }
}
