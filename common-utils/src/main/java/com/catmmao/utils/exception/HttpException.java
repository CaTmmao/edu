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
    // 错误代码
    private String errorCode;

    public HttpException(String message, HttpStatus httpStatus, String errorCode) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    // 找不到资源
    public static HttpException resourceNotFound(String errorCode, String message) {
        return new HttpException(message, HttpStatus.NOT_FOUND, errorCode);
    }

    // 前端请求参数错误
    public static HttpException badRequest(String message, String errorCode) {
        return new HttpException(message, HttpStatus.BAD_REQUEST, errorCode);
    }

    public static HttpException forbidden(String message, String errorCode) {
        return new HttpException(message, HttpStatus.FORBIDDEN, errorCode);
    }

    // 数据库服务出错
    public static HttpException databaseError(String errorCode, String message) {
        return new HttpException(message, HttpStatus.INTERNAL_SERVER_ERROR, errorCode);
    }

    public static HttpException gone(String message, String errorCode) {
        return new HttpException(message, HttpStatus.GONE, errorCode);
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
