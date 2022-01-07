package com.example.review.vote;

import com.example.review.vote.dto.VoteCreationDto;
import com.example.review.vote.dto.VoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.review.common.UrlMappings.API_V1_VOTE_CREATION;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping(value = API_V1_VOTE_CREATION)
    @ResponseStatus(CREATED)
    public VoteDto create(@Valid @RequestBody VoteCreationDto data) {
        var vote = data.toVote();
        var result = voteService.store(vote);
        return VoteDto.of(result);
    }
}
