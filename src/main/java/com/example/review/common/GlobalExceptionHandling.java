package com.example.review.common;

import com.example.review.common.exception.AbstractException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandling {

    private final MessageSourceAccessor messageSourceAccessor;

    @ExceptionHandler(AbstractException.class)
    ResponseEntity<ErrorDto> handleAbstractExceptions(AbstractException e) {
        var code = e.getCode();
        var message = messageSourceAccessor.getMessage(code);
        var error = new ErrorDto(message, code);

        var httpStatus = HttpStatus.valueOf(e.getStatus());

        return ResponseEntity.status(httpStatus).body(error);
    }

}
