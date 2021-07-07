package com.example.swagger.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Data
@Builder
@ToString
public class ApiResult<T> {

    private final T data;
    private final String error;

    public static <T> ApiResult<T> succeed(T data) {
        return new ApiResult<>(data, null);
    }

    public static ApiResult<?> failed(Throwable throwable) {
        return failed(throwable.getMessage());
    }

    public static ApiResult<?> failed(String message) {
        return new ApiResult<>(null, message);
    }

}
