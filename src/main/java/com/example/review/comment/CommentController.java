package com.example.review.comment;

import com.example.review.comment.dto.CommentCreationDto;
import com.example.review.comment.dto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.review.common.UrlMappings.API_V1_COMMENT_CREATION;
import static com.example.review.common.UrlMappings.API_V1_COMMENT_UPDATE;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @ResponseStatus(NO_CONTENT)
    @PostMapping(API_V1_COMMENT_CREATION)
    public void create(@RequestBody CommentCreationDto data) {
        var comments = data.toComment();
        commentService.store(comments);
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping(API_V1_COMMENT_UPDATE)
    public void accepted(@PathVariable Long id, @RequestBody CommentUpdateDto data) {
        commentService.update(id, data.toComment());
    }
}
