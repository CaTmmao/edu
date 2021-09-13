package com.catmmao.utils.exception;

import org.springframework.http.HttpStatus;

/**
 * http 请求过程中遇到的如找不到资源，无权限等错误
 */
public class HttpException extends RuntimeException {
    // 错误信息
    private String message;
    // 状态码
    private HttpStatus httpStatus;

    public HttpException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    // 找不到资源
    public static HttpException resourceNotFound(String message) {
        return new HttpException(message, HttpStatus.NOT_FOUND);
    }

    // 前端请求参数错误
    public static HttpException badRequest(String message) {
        return new HttpException(message, HttpStatus.BAD_REQUEST);
    }

    public static HttpException forbidden(String message) {
        return new HttpException(message, HttpStatus.FORBIDDEN);
    }

    // 数据库服务出错
    public static HttpException databaseError(String message) {
        return new HttpException(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static HttpException gone(String message) {
        return new HttpException(message, HttpStatus.GONE);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
