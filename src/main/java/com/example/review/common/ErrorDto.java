package com.example.review.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.RequiredArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@RequiredArgsConstructor
@JsonAutoDetect(fieldVisibility = ANY)
public final class ErrorDto {

    private final Error error;

    public ErrorDto(String message, String code) {
        this.error = new Error(code, message);
    }

    private record Error(String code, String message) {
    }
}
