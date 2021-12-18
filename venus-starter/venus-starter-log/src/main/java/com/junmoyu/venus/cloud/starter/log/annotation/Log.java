package com.junmoyu.venus.cloud.starter.log.annotation;

import com.junmoyu.venus.cloud.starter.log.enums.BusinessType;
import com.junmoyu.venus.cloud.starter.log.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface Log {

    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequest() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponse() default true;
}
