package com.junmoyu.venus.cloud.starter.core.model.dto;

import java.io.Serializable;

/**
 * 统一返回数据结构
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private String code;

    private String message;

    private T data;

    public Response() {
    }

    private Response(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private Response(Boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<>(true, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(true, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> Response<T> failure() {
        return failure(ResponseCode.SYSTEM);
    }

    public static <T> Response<T> failure(ResponseCode responseCode) {
        return failure(responseCode.getCode(), responseCode.getMessage());
    }

    public static <T> Response<T> failure(ResponseCode responseCode, T data) {
        return failure(responseCode.getCode(), responseCode.getMessage(), data);
    }

    public static <T> Response<T> failure(String code, String message) {
        return new Response<>(false, code, message);
    }

    public static <T> Response<T> failure(String code, String message, T data) {
        return new Response<>(false, code, message, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
