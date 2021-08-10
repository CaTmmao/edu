package com.catmmao.edu.exception;

import com.catmmao.edu.data.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 拦截全局请求异常，不用在每个 controller 中单独处理
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpException.class)
    ResponseEntity<CommonResponse<?>> handleHttpException(HttpException e) {
        CommonResponse<?> responseBody = CommonResponse.error(e.getErrorCode(), e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(responseBody);
    }
}

