package com.junmoyu.venus.cloud.starter.feign.fallback;

import com.junmoyu.venus.cloud.starter.core.model.dto.Response;
import com.junmoyu.venus.cloud.starter.core.model.dto.ResponseCode;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Fallback 代理处理
 *
 * @author moyu.jun
 * @date 2021/12/25
 */
@Slf4j
@AllArgsConstructor
public class VenusFeignFallback<T> implements MethodInterceptor {

    private final Class<T> targetType;
    private final String targetName;
    private final Throwable cause;

    @Nullable
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String errorMessage = cause.getMessage();
        log.error("ShiduFeignFallback:[{}.{}] serviceId:[{}] message:[{}]", targetType.getName(), method.getName(), targetName, errorMessage);
        Class<?> returnType = method.getReturnType();
        // 暂时不支持 flux，rx，异步等，返回值不是 Response，直接返回 null。
        if (Response.class != returnType) {
            return null;
        }
        // 非 FeignException
        if (!(cause instanceof FeignException)) {
            return Response.failure(ResponseCode.SYSTEM, errorMessage);
        }
        FeignException exception = (FeignException) cause;
        String content = exception.contentUTF8();
        // 如果返回的数据为空
        if (ObjectUtils.isEmpty(content)) {
            return Response.failure(ResponseCode.SYSTEM, errorMessage);
        }
        return Response.failure(ResponseCode.SYSTEM, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VenusFeignFallback<?> that = (VenusFeignFallback<?>) o;
        return targetType.equals(that.targetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetType);
    }
}
