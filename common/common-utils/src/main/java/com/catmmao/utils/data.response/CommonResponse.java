package com.catmmao.utils.data.response;

import java.util.Collections;

// 接口常用返回类型
public class CommonResponse<T> {
    // 消息内容
    protected String message = "success";
    // 数据
    protected T data;

    protected CommonResponse() {
    }

    /**
     * 成功
     *
     * @param data 数据
     * @param <T>  数据类型
     * @return 响应数据
     */
    public static <T> CommonResponse<T> ok(T data) {
        CommonResponse<T> result = new CommonResponse<>();
        result.setData(data);
        return result;
    }

    /**
     * 失败
     *
     * @param message 错误信息
     * @return 响应数据
     */
    public static CommonResponse<Object> error(String message) {
        CommonResponse<Object> result = new CommonResponse<>();
        result.setMessage(message);
        result.setData(Collections.emptyMap());
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String errorMessage) {
        this.message = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
