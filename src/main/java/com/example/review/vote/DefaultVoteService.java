package com.example.review.vote;

import com.example.review.product.config.ProductConfigService;
import com.example.review.vote.exception.VoteAlreadyExistsException;
import com.example.review.vote.exception.VoteNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultVoteService implements VoteService {

    private final VoteRepository voteRepository;
    private final ProductConfigService productConfigService;

    @Override
    public Vote store(Vote vote) {
        checkAllowedVoting(vote);
        //TODO: check user role
        try {
            return voteRepository.save(vote);
        } catch (DataIntegrityViolationException e) {
            throw new VoteAlreadyExistsException();
        }
    }

    @Override
    public float getAverageScore(long productId) {
        return voteRepository.getAverageScore(productId).orElse((float) 0);
    }

    private void checkAllowedVoting(Vote vote) {
        var productConfig = productConfigService.getByProductId(vote.getProductId());
        if (Boolean.FALSE.equals(productConfig.getVotable()) || Boolean.FALSE.equals(productConfig.getVisible())) {
            throw new VoteNotAllowedException();
        }
    }
}
