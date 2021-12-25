package com.junmoyu.venus.cloud.starter.feign.fallback;

import feign.Target;
import lombok.AllArgsConstructor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * 默认 Fallback，减少编写必要的 Fallback 类
 *
 * @author moyu.jun
 * @date 2021/12/25
 */
@AllArgsConstructor
public class VenusFallbackFactory<T> implements FallbackFactory<T> {

    private final Target<T> target;

    @Override
    @SuppressWarnings("unchecked")
    public T create(Throwable cause) {
        final Class<T> targetType = target.type();
        final String targetName = target.name();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetType);
        enhancer.setUseCache(true);
        enhancer.setCallback(new VenusFeignFallback<>(targetType, targetName, cause));
        return (T) enhancer.create();
    }
}
