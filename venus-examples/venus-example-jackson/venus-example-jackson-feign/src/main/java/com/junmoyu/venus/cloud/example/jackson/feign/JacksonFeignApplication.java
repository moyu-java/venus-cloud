package com.junmoyu.venus.cloud.example.jackson.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author moyu.jun
 * @date 2021/12/25
 */
@EnableFeignClients
@SpringBootApplication
public class JacksonFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(JacksonFeignApplication.class, args);
    }
}
