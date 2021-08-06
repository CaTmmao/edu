package com.catmmao.edu.data.response;

// 接口统一返回类型
public class CommonResponse<T> {
    // 是否成功
    private boolean success;
    // 信息
    private String errorMessage;
    // 数据
    private T data;

    private CommonResponse(boolean isSuccess, String message, T data) {
        this.success = isSuccess;
        this.errorMessage = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> ok(T data) {
        return new CommonResponse<>(true, null, data);
    }

    public static <T> CommonResponse<T> error(String message) {
        return new CommonResponse<>(false, message, null);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
