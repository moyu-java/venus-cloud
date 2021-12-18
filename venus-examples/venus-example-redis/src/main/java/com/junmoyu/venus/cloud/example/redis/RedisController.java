package com.junmoyu.venus.cloud.example.redis;

import com.junmoyu.venus.cloud.example.redis.model.User;
import com.junmoyu.venus.cloud.starter.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis 测试接口
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
@RestController
@RequestMapping("redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/users")
    public String setObject(User user) {
        redisService.setCacheObject("user.info", user);
        return "success.";
    }

    @GetMapping("/users")
    public User getObject() {
        return redisService.getCacheObject("user.info");
    }
}
