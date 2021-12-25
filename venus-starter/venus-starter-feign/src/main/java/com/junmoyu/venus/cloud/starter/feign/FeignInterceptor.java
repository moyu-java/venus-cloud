package com.junmoyu.venus.cloud.starter.feign;

import com.junmoyu.venus.cloud.starter.core.constant.CommonConstants;
import com.junmoyu.venus.cloud.starter.core.util.TraceUtils;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Feign 拦截器
 *
 * @author moyu.jun
 * @date 2021/12/25
 */
@Slf4j
public class FeignInterceptor {

    /**
     * 使用 feign client 发送请求时，传递 tenantId 和 traceId
     *
     * @return {@link RequestInterceptor}
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // 传递日志 traceId
            String traceId = MDC.get(CommonConstants.LOG_TRACE_ID);
            if (StringUtils.isBlank(traceId)) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (attributes == null) {
                    return;
                }
                HttpServletRequest request = attributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames == null) {
                    return;
                }

                String headerName = null;
                while (headerNames.hasMoreElements()) {
                    headerName = headerNames.nextElement();
                    if (headerName.equalsIgnoreCase(CommonConstants.VENUS_TRACE_ID)) {
                        traceId = request.getHeader(headerName);
                        requestTemplate.header(CommonConstants.VENUS_TRACE_ID, traceId);
                        TraceUtils.mdcTraceId(traceId);
                    }
                    String values = request.getHeader(headerName);
                    requestTemplate.header(headerName, values);
                }
            } else {
                requestTemplate.header(CommonConstants.VENUS_TRACE_ID, traceId);
            }
        };
    }
}
