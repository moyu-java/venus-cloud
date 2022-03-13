package com.junmoyu.venus.cloud.example.single.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moyu.jun
 * @date 2022/3/10
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("")
    public String test(){
        log.info("test api.");
        return "ok";
    }
}
