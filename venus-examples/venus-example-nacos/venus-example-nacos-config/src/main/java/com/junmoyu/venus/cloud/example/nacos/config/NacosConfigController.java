package com.junmoyu.venus.cloud.example.nacos.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moyu.jun
 * @date 2022/3/13
 */
@RestController
@RequestMapping("/nacos/config")
@RequiredArgsConstructor
public class NacosConfigController {

    @Value("${test01}")
    String test01;
    @Value("${test02}")
    String test02;
    @Value("${test03}")
    String test03;
    @Value("${test}")
    String test;

    @GetMapping("/test01")
    private String test01() {
        return test01;
    }


    @GetMapping("/test02")
    private String test02() {
        return test02;
    }


    @GetMapping("/test03")
    private String test03() {
        return test03;
    }


    @GetMapping("/test")
    private String test() {
        return test;
    }
}
