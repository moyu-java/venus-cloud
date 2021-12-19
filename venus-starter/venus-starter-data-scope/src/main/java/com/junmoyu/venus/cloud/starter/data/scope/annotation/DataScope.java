package com.junmoyu.venus.cloud.starter.data.scope.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataScope {

    /**
     * 部门表的别名
     */
    String deptAlias() default "";

    /**
     * 用户表的别名
     */
    String userAlias() default "";
}
