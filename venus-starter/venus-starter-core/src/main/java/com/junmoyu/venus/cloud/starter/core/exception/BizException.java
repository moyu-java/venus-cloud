package com.junmoyu.venus.cloud.starter.core.exception;

import com.junmoyu.venus.cloud.starter.core.model.dto.ResponseCode;

/**
 * 自定义业务异常
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    public BizException(String message) {
        this(ResponseCode.SYSTEM.getCode(), message);
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(ResponseCode responseCode) {
        this(responseCode.getCode(), responseCode.getMessage());
    }

    public BizException(String message, Throwable e) {
        this(ResponseCode.SYSTEM.getCode(), message, e);
    }

    public BizException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public BizException(ResponseCode responseCode, Throwable e) {
        this(responseCode.getCode(), responseCode.getMessage(), e);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
