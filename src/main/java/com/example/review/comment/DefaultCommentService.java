package com.example.review.comment;

import com.example.review.comment.exception.CommentAlreadyAcceptedException;
import com.example.review.comment.exception.CommentAlreadyRejectedException;
import com.example.review.comment.exception.CommentNotAllowedException;
import com.example.review.comment.exception.CommentNotFoundException;
import com.example.review.product.config.ProductConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.review.comment.Comment.CommentStatus.ACCEPTED;
import static com.example.review.comment.Comment.CommentStatus.REJECTED;

@Service
@RequiredArgsConstructor
public class DefaultCommentService implements CommentService {

    private final CommentRepository commentRepository;
    private final ProductConfigService productConfigService;

    @Override
    public Comment store(Comment comment) {
        var productConfig = productConfigService.getByProductId(comment.getProductId());
        if (Boolean.FALSE.equals(productConfig.getCommentable()) || Boolean.FALSE.equals(productConfig.getVisible())) {
            throw new CommentNotAllowedException();
        }
        //TODO: check user role
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Long id, Comment data) {
        var comment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        if (comment.getStatus() == ACCEPTED) throw new CommentAlreadyAcceptedException();
        if (comment.getStatus() == REJECTED) throw new CommentAlreadyRejectedException();

        comment.setStatus(data.getStatus());
        return commentRepository.save(comment);

    }

    @Override
    public long getCount(long productId) {
        return commentRepository.countByProductId(productId);
    }

    @Override
    public List<Comment> getLast3Comments(long productId) {
        return commentRepository.findTop3ByProductIdOrderByCreatedAtDesc(productId);
    }
}
